package cafe.speciality.kochere.mvp.feature.places

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import cafe.speciality.kochere.di.component.ActivityComponent
import cafe.speciality.kochere.di.module.activity.PlacesModule
import cafe.speciality.kochere.mvp.base.BaseActivity
import cafe.speciality.kochere.mvp.feature.place.PlaceDetailsActivity
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.repository.model.Place
import cafe.speciality.kochere.repository.model.Places
import kotlinx.android.synthetic.main.places_activity.*
import javax.inject.Inject


/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesActivity : BaseActivity<PlacesContract.View, PlacesContract.Presenter>(), PlacesContract.View {
    @Inject
    lateinit var adapter: PlacesAdapter

    lateinit var places_recycler: RecyclerView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
        initToolbar()
    }

    override fun displayList(list: List<Places>) {
        adapter.listItem = list
    }

    override fun showPlaceDetails(place: Place) {
        PlaceDetailsActivity.startActivity(this, place)
    }

    override fun showFindMorePlacesView() {

    }

    override fun showDialogWithAskOfPermission() {

    }

    override fun showError(message: String) {

    }

    private fun initRecycler() {
        places_recycler.adapter = adapter;
        places_recycler.layoutManager = initLayoutManager()
        places_recycler.setHasFixedSize(true)
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