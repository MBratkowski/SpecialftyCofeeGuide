package io.bratexsoft.specialtycofeecode.domain

import android.arch.lifecycle.LiveData
import io.bratexsoft.specialtycofeecode.domain.base.UseCase
import io.bratexsoft.specialtycofeecode.repository.RestaurantRepository
import io.bratexsoft.specialtycofeecode.repository.model.RestaurantDetails

/**
 * Created by mateuszbratkowski on 07/01/2018.
 */
class GetRestaurantDetailsUsecase constructor(private val repository: RestaurantRepository) : UseCase<LiveData<RestaurantDetails>> {

    override fun execute(): LiveData<RestaurantDetails> {
        return repository.getRestaurantDetails()
    }
}