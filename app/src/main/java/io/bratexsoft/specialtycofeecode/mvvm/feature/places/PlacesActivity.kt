package io.bratexsoft.specialtycofeecode.mvvm.feature.places

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
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.PlacesActivityBinding
import io.bratexsoft.specialtycofeecode.di.component.ActivityComponent
import io.bratexsoft.specialtycofeecode.di.module.activity.PlacesModule
import io.bratexsoft.specialtycofeecode.mvvm.base.BaseActivity
import io.bratexsoft.specialtycofeecode.mvvm.feature.place.PlaceDetailsActivity
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.ItemClickListener
import io.bratexsoft.specialtycofeecode.repository.model.Place


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