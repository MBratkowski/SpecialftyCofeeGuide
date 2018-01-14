package cafe.speciality.kochere.mvvm.feature.places

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.location.Location
import cafe.speciality.kochere.domain.GetPlacesUseCase
import cafe.speciality.kochere.mvvm.feature.places.item.BottomItemViewModel
import cafe.speciality.kochere.mvvm.feature.places.item.FeaturedItemViewModel
import cafe.speciality.kochere.mvvm.feature.places.item.PlacesType
import cafe.speciality.kochere.mvvm.feature.places.item.RegularItemViewModel
import cafe.speciality.kochere.repository.model.processSpecialization

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesViewModel(private val useCase: GetPlacesUseCase, private val map: HashMap<String, String>) : ViewModel() {

    private var data: MediatorLiveData<MutableList<PlacesType>> = MediatorLiveData()

    fun getPlaces(location: Location): LiveData<MutableList<PlacesType>> {
        useCase.location = location
        val places = useCase.execute()
        data.addSource(places, {
            val listOfPlaces: MutableList<PlacesType> = ArrayList()
            places.value?.featured?.map {
                val headerItemVIew = FeaturedItemViewModel(it)
                headerItemVIew.restaurantName.set(it.name)
                headerItemVIew.restaurantImage.set(it.coverURL)
                headerItemVIew.restaurantSpecialization.set(it.processSpecialization(map))
                listOfPlaces.add(headerItemVIew)
            }

            places.value?.regular?.forEach {
                val regularItemView = RegularItemViewModel(it)
                regularItemView.restaurantName.set(it.name)
                regularItemView.restaurantImage.set(it.thumbnailURL)
                regularItemView.restaurantSpecialization.set(it.processSpecialization(map))
                listOfPlaces.add(regularItemView)
            }

            listOfPlaces.add(listOfPlaces.size, BottomItemViewModel())

            data.postValue(listOfPlaces)
            data.removeSource(places)
        })

        return data
    }


    class Factory constructor(private val useCase: GetPlacesUseCase, private val map: HashMap<String, String>) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PlacesViewModel(useCase, map) as T
        }
    }

}