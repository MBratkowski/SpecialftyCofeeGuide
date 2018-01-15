package cafe.speciality.kochere.repository

import cafe.speciality.kochere.repository.model.LocationData
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.remote.DataCallback

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
interface PlacesRepositoryDefinition {

    fun getPlaces(location: LocationData, callback : DataCallback<Places>)
}