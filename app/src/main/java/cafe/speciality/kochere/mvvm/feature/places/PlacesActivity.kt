package cafe.speciality.kochere.mvvm.feature.places

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Bundle
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
import cafe.speciality.kochere.support.LocationProvider
import javax.inject.Inject


/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesActivity : BaseActivity<PlacesActivityBinding, PlacesViewModel>(), LocationProvider.LocationChangeListener, ItemClickListener {

    @Inject
    lateinit var locationProvider: LocationProvider

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, PlacesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutRest(): Int = R.layout.places_activity

    override fun performFieldInjection(activityComponent: ActivityComponent) {
        activityComponent.plusModule(PlacesModule()).inject(this)
    }

    override fun onRegularItemClick(place: Place) {
        PlaceDetailsActivity.startActivity(this, place)
    }

    override fun onLocationChanged(location: Location) {
        viewModel.getPlaces(location).observe(this, Observer {
            it?.let {
                val adapter = binding.recycler.adapter as PlacesAdapter
                adapter.listItem = it.toList()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
        initToolbar()
        locationProvider.requestLocation()
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
}