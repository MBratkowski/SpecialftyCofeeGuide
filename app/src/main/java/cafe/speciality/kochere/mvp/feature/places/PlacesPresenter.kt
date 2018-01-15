package cafe.speciality.kochere.mvp.feature.places

import cafe.speciality.kochere.domain.UseCaseFactory
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.FeaturedItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.RegularItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlacesType
import cafe.speciality.kochere.repository.model.Place
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.model.processSpecialization
import cafe.speciality.kochere.repository.remote.DataCallback
import cafe.speciality.kochere.support.LocationPermissionSupport
import cafe.speciality.kochere.support.LocationProvider

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class PlacesPresenter constructor(private val useCaseFactory: UseCaseFactory,
                                  private val locationPermissionSupport: LocationPermissionSupport,
                                  private val locationProvider: LocationProvider,
                                  private val map: HashMap<String, String>) : PlacesContract.Presenter(), DataCallback<Places> {
    companion object {
        const val LAYOUT_MANAGER_GRID = 2
        const val ONE_COLUMN_GRID = 2
        const val TWO_COLUMNS_GRID = 1
    }

    var places: List<Place> = emptyList()

    override fun getList(): List<PlacesType> = emptyList()

    override fun setSpanSize(position: Int): Int {
        return when (places[position].getViewType()) {
            1 -> TWO_COLUMNS_GRID
            2 -> TWO_COLUMNS_GRID
            else -> ONE_COLUMN_GRID
        }
    }

    override fun onAttachedView() {
        if (locationPermissionSupport.hasPermissionToAccessLocation()) {
            useCaseFactory.provideGetPlacesUseCase(locationProvider.requestLocation(), this)

        } else {
            view.showDialogWithAskOfPermission()
        }
    }

    override fun onSuccess(data: Places) {

    }

    override fun onFailure(message: String) {
        view.showError(message)
    }

    override fun getCount(): Int = places.size

    override fun onBindItemRegular(position: Int, holder: RegularItemViewHolder) {
        holder.showCover(places[position].coverURL)
        holder.showSpecialization(places[position].processSpecialization(map))
        holder.showTitle(places[position].name)
    }

    override fun onBindItemFeatured(position: Int, holder: FeaturedItemViewHolder) {
        holder.showCover(places[position].coverURL)
        holder.showSpecialization(places[position].processSpecialization(map))
        holder.showTitle(places[position].name)
    }

    override fun onBottomItemClick() {
        view.showFindMorePlacesView()
    }

    override fun onRegularItemClick(position: Int) {
        view.showPlaceDetails(places[position])
    }
}