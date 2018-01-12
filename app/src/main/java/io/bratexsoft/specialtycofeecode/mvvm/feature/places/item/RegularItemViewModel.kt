package io.bratexsoft.specialtycofeecode.mvvm.feature.places.item

import io.bratexsoft.specialtycofeecode.repository.model.Place

/**
 * Created by mateuszbratkowski on 03/01/2018.
 */
class RegularItemViewModel constructor(val place: Place) : PlacesType() {

    override fun getViewType(): Int {
        return ITEM_REGULAR
    }
}