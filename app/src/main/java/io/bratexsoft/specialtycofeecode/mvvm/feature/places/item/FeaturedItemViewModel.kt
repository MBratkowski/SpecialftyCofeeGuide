package io.bratexsoft.specialtycofeecode.mvvm.feature.places.item

import io.bratexsoft.specialtycofeecode.repository.model.Place

/**
 * Created by mateuszbratkowski on 06/01/2018.
 */
class FeaturedItemViewModel constructor(val place: Place) : PlacesType() {

    override fun getViewType(): Int = PlacesType.ITEM_FEATURED

}