package cafe.speciality.kochere.repository.remote

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
interface DataCallback<T> {
    fun onSuccess(data: T)

    fun onFailure(message: String)
}