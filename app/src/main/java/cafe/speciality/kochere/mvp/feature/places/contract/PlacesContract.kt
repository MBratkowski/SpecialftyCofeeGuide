package cafe.speciality.kochere.mvp.feature.places.contract

import cafe.speciality.kochere.mvp.base.BasePresenter
import cafe.speciality.kochere.mvp.base.BaseView
import cafe.speciality.kochere.mvp.feature.places.item.FeaturedItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.RegularItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType
import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
interface PlacesContract {

    abstract class Presenter : BasePresenter<View>() {

        abstract fun onRegularItemClick(position: Int)

        abstract fun onBottomItemClick()

        abstract fun getPlaces()

        abstract fun getCount(): Int

        abstract fun getList(): List<PlaceViewType>

        abstract fun setSpanSize(position: Int): Int

        abstract fun onBindItemRegular(position: Int, holder: RegularItemViewHolder)

        abstract fun onBindItemFeatured(position: Int, holder: FeaturedItemViewHolder)
    }

    interface View : BaseView {
        fun displayList(list: List<PlaceViewType>)

        fun showPlaceDetails(place: Place)

        fun showFindMorePlacesView()

        fun showLoading()

        fun hideLoading();

        fun showDialogWithAskOfPermission()
    }
}