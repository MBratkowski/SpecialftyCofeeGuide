package cafe.speciality.kochere.mvvm.feature.places.item

import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 11/01/2018.
 */
interface ItemClickListener {

    fun onRegularItemClick(place: Place)
}