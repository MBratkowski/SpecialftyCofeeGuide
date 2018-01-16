package cafe.speciality.kochere.mvp.feature.places

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View.GONE
import android.view.View.VISIBLE
import cafe.speciality.kochere.R
import cafe.speciality.kochere.di.component.ActivityComponent
import cafe.speciality.kochere.di.module.activity.PlacesModule
import cafe.speciality.kochere.mvp.base.BaseActivity
import cafe.speciality.kochere.mvp.feature.place.PlaceDetailsActivity
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType
import cafe.speciality.kochere.repository.model.Place
import cafe.speciality.kochere.support.PlacesItemDecoration
import kotlinx.android.synthetic.main.places_activity.*
import javax.inject.Inject


/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesActivity : BaseActivity<PlacesContract.View, PlacesContract.Presenter>(), PlacesContract.View {

    @Inject
    lateinit var adapter: PlacesAdapter

    private val requestPermission: Int = 200

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, PlacesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            requestPermission -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    presenter.getPlaces()
                }
            }
        }
    }

    override fun getLayoutRest(): Int = R.layout.places_activity

    override fun performFieldInjection(activityComponent: ActivityComponent) {
        activityComponent.plusModule(PlacesModule()).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
        initToolbar()
    }

    override fun showPlaceDetails(place: Place) {
        PlaceDetailsActivity.startActivity(this, place)
    }

    override fun showFindMorePlacesView() {

    }

    override fun displayList(list: List<PlaceViewType>) {
        adapter.listItem = list
    }

    override fun hideLoading() {
        progressBar.visibility = GONE
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun showDialogWithAskOfPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
                requestPermission)
    }

    override fun showError(message: String) {

    }

    private fun initRecycler() {
        places_recycler.layoutManager = initLayoutManager()
        places_recycler.setHasFixedSize(true)
        places_recycler.addItemDecoration(PlacesItemDecoration(this, R.drawable.places_item_decoration))
        places_recycler.adapter = adapter
    }

    private fun initLayoutManager(): RecyclerView.LayoutManager {
        val layoutManager = GridLayoutManager(this, PlacesPresenter.LAYOUT_MANAGER_GRID)
        layoutManager.spanSizeLookup = (object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return presenter.setSpanSize(position)
            }
        })

        return layoutManager
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }
}