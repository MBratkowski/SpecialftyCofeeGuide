package cafe.speciality.kochere.repository.network

import cafe.speciality.kochere.repository.model.Places
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
interface RequestDefinition {

    @GET("places/")
    fun getRestaurantList(@Query("latitude") latitude: String,
                          @Query("longitude") longitude: String): Call<Places>
}