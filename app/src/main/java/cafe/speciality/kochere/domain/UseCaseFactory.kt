package cafe.speciality.kochere.domain

import cafe.speciality.kochere.repository.PlacesRepositoryDefinition
import cafe.speciality.kochere.repository.model.LocationData
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.remote.DataCallback

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class UseCaseFactory constructor(private val repository: PlacesRepositoryDefinition) {

    fun provideGetPlacesUseCase(locationData: LocationData,
                                callback: DataCallback<Places>): GetPlacesUseCase {
        return GetPlacesUseCase(repository, locationData, callback)
    }
}