package io.bratexsoft.specialtycofeecode.repository

import android.arch.lifecycle.MutableLiveData
import android.location.Location
import io.bratexsoft.specialtycofeecode.repository.model.Places

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
interface PlacesRepositoryDefinition {

    fun getPlaces(location: Location, data: MutableLiveData<Places>)
}