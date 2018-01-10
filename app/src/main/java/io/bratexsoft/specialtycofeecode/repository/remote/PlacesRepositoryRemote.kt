package io.bratexsoft.specialtycofeecode.repository.remote

import android.arch.lifecycle.MutableLiveData
import android.location.Location
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.repository.PlacesRepositoryDefinition
import io.bratexsoft.specialtycofeecode.repository.model.Places
import io.bratexsoft.specialtycofeecode.repository.network.RequestDefinition
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@PerView
class PlacesRepositoryRemote @Inject constructor(private val service: RequestDefinition) : PlacesRepositoryDefinition {

    override fun getPlaces(location: Location, data: MutableLiveData<Places>) {
        service.getRestaurantList(location.latitude.toString(), location.longitude.toString()).enqueue(object : Callback<Places> {
            override fun onResponse(call: Call<Places>?, response: Response<Places>?) {
                data.value = response?.body()
            }

            override fun onFailure(call: Call<Places>?, t: Throwable?) {
            }

        })
    }

}