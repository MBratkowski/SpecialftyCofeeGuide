package cafe.speciality.kochere.mvp.feature.places

import cafe.speciality.kochere.domain.UseCaseFactory
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.*
import cafe.speciality.kochere.mvp.feature.places.item.definition.DataContent
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType
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
                                  private val stringResources: HashMap<String, String>) : PlacesContract.Presenter(), DataCallback<Places> {
    companion object {

        const val LAYOUT_MANAGER_GRID = 2
        const val ONE_COLUMN_GRID = 2
        const val TWO_COLUMNS_GRID = 1
    }

    var places: MutableList<PlaceViewType> = mutableListOf()

    override fun getList(): List<PlaceViewType> = places

    override fun setSpanSize(position: Int): Int {
        return when (position) {
            1 -> TWO_COLUMNS_GRID
            2 -> TWO_COLUMNS_GRID
            else -> ONE_COLUMN_GRID
        }
    }

    override fun onAttachedView() {
        if (locationPermissionSupport.hasPermissionToAccessLocation()) {
            getPlaces()
        } else {
            view.showDialogWithAskOfPermission()
        }
    }

    override fun getPlaces() {
        useCaseFactory.provideGetPlacesUseCase(locationProvider.requestLocation(), this).execute()
    }

    override fun onSuccess(data: Places) {
        data.featured.forEach {
            places.add(FeaturedItem(it))
        }

        data.regular.forEach {
            places.add(RegularItem(it))
        }

        places.add(BottomItem())
        view.hideLoading()
        view.displayList(places)
    }

    override fun onFailure(message: String) {
        view.showError(message)
    }

    override fun getCount(): Int = places.size

    override fun onBindItemRegular(position: Int, holder: RegularItemViewHolder) {
        val itemRegular = places[position] as DataContent<Place>
        holder.showCover(itemRegular.data.thumbnailURL)
        holder.showSpecialization(itemRegular.data.processSpecialization(stringResources))
        holder.showTitle(itemRegular.data.name)
    }

    override fun onBindItemFeatured(position: Int, holder: FeaturedItemViewHolder) {
        val itemFeatured = places[position] as DataContent<Place>
        holder.showCover(itemFeatured.data.coverURL)
        holder.showSpecialization(itemFeatured.data.processSpecialization(stringResources))
        holder.showTitle(itemFeatured.data.name)
    }

    override fun onBottomItemClick() {
        view.showFindMorePlacesView()
    }

    override fun onRegularItemClick(position: Int) {
        val item= places[position] as DataContent<Place>
        view.showPlaceDetails(item.data)
    }
}