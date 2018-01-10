package io.bratexsoft.specialtycofeecode.mvvm.feature.places

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.location.Location
import io.bratexsoft.specialtycofeecode.domain.GetPlacesUseCase
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.BottomItemViewModel
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.FeaturedItemViewModel
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.PlacesType
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.RegularItemViewModel

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesViewModel(private val useCase: GetPlacesUseCase) : ViewModel() {

    private var data: MediatorLiveData<MutableList<PlacesType>> = MediatorLiveData()

    fun getPlaces(location: Location): LiveData<MutableList<PlacesType>> {
        useCase.location = location
        val places = useCase.execute()
        data.addSource(places, {
            val listOfPlaces: MutableList<PlacesType> = ArrayList()
            places.value?.featured?.map {
                val headerItemVIew = FeaturedItemViewModel()
                headerItemVIew.restaurantName.set(it.name)
                headerItemVIew.restaurantImage.set(it.coverURL)
                listOfPlaces.add(headerItemVIew)
            }

            places.value?.regular?.forEach {
                val regularItemView = RegularItemViewModel()
                regularItemView.restaurantName.set(it.name)
                regularItemView.restaurantImage.set(it.thumbnailURL)
                listOfPlaces.add(regularItemView)
            }

            listOfPlaces.add(listOfPlaces.size, BottomItemViewModel())

            data.postValue(listOfPlaces)
            data.removeSource(places)
        })

        return data
    }

    class Factory constructor(private val useCase: GetPlacesUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PlacesViewModel(useCase) as T
        }
    }

}