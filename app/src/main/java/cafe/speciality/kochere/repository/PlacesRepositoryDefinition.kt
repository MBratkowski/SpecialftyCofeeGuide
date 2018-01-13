package cafe.speciality.kochere.repository

import android.arch.lifecycle.MutableLiveData
import android.location.Location
import cafe.speciality.kochere.repository.model.Places

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
interface PlacesRepositoryDefinition {

    fun getPlaces(location: Location, data: MutableLiveData<Places>)
}