package cafe.speciality.kochere.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.location.Location
import cafe.speciality.kochere.domain.base.UseCase
import cafe.speciality.kochere.repository.PlacesRepositoryDefinition
import cafe.speciality.kochere.repository.model.Places

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class GetPlacesUseCase constructor(private val repository: PlacesRepositoryDefinition) : UseCase<LiveData<Places>> {

    lateinit var location: Location

    override fun execute(): LiveData<Places> {
        val data: MutableLiveData<Places> = MutableLiveData()
        repository.getPlaces(location, data)
        return data
    }
}