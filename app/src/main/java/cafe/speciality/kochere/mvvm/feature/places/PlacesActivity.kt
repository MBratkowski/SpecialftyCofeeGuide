package cafe.speciality.kochere.mvvm.feature.places

import android.Manifest
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import cafe.speciality.kochere.R
import cafe.speciality.kochere.databinding.PlacesActivityBinding
import cafe.speciality.kochere.di.component.ActivityComponent
import cafe.speciality.kochere.di.module.activity.PlacesModule
import cafe.speciality.kochere.mvvm.base.BaseActivity
import cafe.speciality.kochere.mvvm.feature.place.PlaceDetailsActivity
import cafe.speciality.kochere.mvvm.feature.places.item.ItemClickListener
import cafe.speciality.kochere.repository.model.Place
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric


/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesActivity : BaseActivity<PlacesActivityBinding, PlacesViewModel>(), ActivityCompat.OnRequestPermissionsResultCallback, ItemClickListener {

    override fun getLayoutRest(): Int = R.layout.places_activity

    override fun performFieldInjection(activityComponent: ActivityComponent) {
        activityComponent.plusModule(PlacesModule()).inject(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            0 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val locationManager: LocationManager = this.applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

                    viewModel.getPlaces(Location("New place")).observe(this, Observer {
                        it?.let {
                            val adapter = binding.recycler.adapter as PlacesAdapter
                            adapter.listItem = it.toList()
                        }
                    })

                } else {

                }
                return
            }
        }
    }

    override fun onRegularItemClick(place: Place) {
        PlaceDetailsActivity.startActivity(this, place)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        initRecycler()
        initToolbar()
        requestToPermission()
    }

    private fun initRecycler() {
        binding.recycler.adapter = PlacesAdapter(this)
        binding.recycler.layoutManager = initLayoutManager()
        binding.recycler.setHasFixedSize(true)
    }

    private fun initLayoutManager(): RecyclerView.LayoutManager {
        val layoutManager = GridLayoutManager(this, PlacesAdapter.LAYOUT_MANAGER_GRID)
        layoutManager.spanSizeLookup = (object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    1 -> PlacesAdapter.TWO_COLUMNS_GRID
                    2 -> PlacesAdapter.TWO_COLUMNS_GRID
                    else -> PlacesAdapter.ONE_COLUMN_GRID
                }
            }
        })

        return layoutManager
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun requestToPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION), 0)
    }
}