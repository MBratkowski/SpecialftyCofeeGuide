package io.bratexsoft.specialtycofeecode.domain

import android.arch.lifecycle.LiveData
import io.bratexsoft.specialtycofeecode.domain.base.UseCase
import io.bratexsoft.specialtycofeecode.repository.RestaurantRepository
import io.bratexsoft.specialtycofeecode.repository.model.Restaurant

/**
 * Created by mateuszbratkowski on 04/01/2018.
 */
class GetRestaurantListUseCase constructor(private val repository: RestaurantRepository) : UseCase<LiveData<List<Restaurant>>> {

    override fun execute(): LiveData<List<Restaurant>> = repository.getRestaurantList()
}