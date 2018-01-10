package io.bratexsoft.specialtycofeecode.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.bratexsoft.specialtycofeecode.repository.model.Restaurant
import io.bratexsoft.specialtycofeecode.repository.model.RestaurantDetails

/**
 * Created by mateuszbratkowski on 04/01/2018.
 */
class RestaurantRepository : RestaurantRepositoryDefinition {

    override fun getRestaurantList(): LiveData<List<Restaurant>> {
        val restaurantList: MutableLiveData<List<Restaurant>> = MutableLiveData()
        restaurantList.value = prepareList()

        return restaurantList
    }

    override fun getRestaurantDetails(): LiveData<RestaurantDetails> {
        return MutableLiveData()
    }

    private fun prepareList(): List<Restaurant> {
        return listOf(Restaurant("Gniazdo", true),
                Restaurant("Paloma", true),
                Restaurant("Starbucks", true),
                Restaurant("Dinette", false),
                Restaurant("Bema cafe", false),
                Restaurant("Charlotte", false),
                Restaurant("Bike Cafe", false),
                Restaurant("Vincent Cafe", false))
    }
}