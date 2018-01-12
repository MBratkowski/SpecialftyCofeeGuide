package io.bratexsoft.specialtycofeecode.mvvm.feature.places.item

import io.bratexsoft.specialtycofeecode.repository.model.Place

/**
 * Created by mateuszbratkowski on 11/01/2018.
 */
interface ItemClickListener {

    fun onRegularItemClick(place: Place)
}