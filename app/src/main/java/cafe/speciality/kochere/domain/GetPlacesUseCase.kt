package cafe.speciality.kochere.domain

import cafe.speciality.kochere.domain.base.UseCase
import cafe.speciality.kochere.repository.PlacesRepositoryDefinition
import cafe.speciality.kochere.repository.model.LocationData
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.remote.DataCallback

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class GetPlacesUseCase constructor(private val repository: PlacesRepositoryDefinition,
                                   private val locationData: LocationData,
                                   private val callback: DataCallback<Places>) : UseCase {

    override fun execute() {
        return repository.getPlaces(locationData, callback)
    }
}