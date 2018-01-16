package cafe.speciality.kochere.domain

import cafe.speciality.kochere.repository.model.LocationData
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.remote.DataCallback
import cafe.speciality.kochere.repository.remote.PlacesRepositoryRemote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
@Singleton
class UseCaseFactory @Inject constructor(private val repository: PlacesRepositoryRemote) {

    fun provideGetPlacesUseCase(locationData: LocationData,
                                callback: DataCallback<Places>): GetPlacesUseCase {
        return GetPlacesUseCase(repository, locationData, callback)
    }
}