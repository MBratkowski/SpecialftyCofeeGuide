package cafe.speciality.kochere.repository.remote

import cafe.speciality.kochere.di.scope.PerView
import cafe.speciality.kochere.repository.PlacesRepositoryDefinition
import cafe.speciality.kochere.repository.model.LocationData
import cafe.speciality.kochere.repository.model.Places
import cafe.speciality.kochere.repository.network.RequestDefinition
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@PerView
class PlacesRepositoryRemote @Inject constructor(private val service: RequestDefinition) : PlacesRepositoryDefinition {

    override fun getPlaces(location: LocationData, callback: DataCallback<Places>) {
        service.getRestaurantList(location.latitude,
                location.longitude).enqueue(object : Callback<Places> {
            override fun onResponse(call: Call<Places>?, response: Response<Places>?) {
                callback.onSuccess(response?.body()!!)
            }

            override fun onFailure(call: Call<Places>?, throwable: Throwable?) {
                callback.onFailure(throwable?.message!!)
            }

        })
    }

}