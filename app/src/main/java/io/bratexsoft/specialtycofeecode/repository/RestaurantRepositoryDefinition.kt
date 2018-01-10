package io.bratexsoft.specialtycofeecode.repository

import android.arch.lifecycle.LiveData
import io.bratexsoft.specialtycofeecode.repository.model.Restaurant
import io.bratexsoft.specialtycofeecode.repository.model.RestaurantDetails

/**
 * Created by mateuszbratkowski on 07/01/2018.
 */
interface RestaurantRepositoryDefinition {

    fun getRestaurantList(): LiveData<List<Restaurant>>

    fun getRestaurantDetails(): LiveData<RestaurantDetails>
}