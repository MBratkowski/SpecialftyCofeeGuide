package io.bratexsoft.specialtycofeecode.mvvm.feature.places.item

/**
 * Created by mateuszbratkowski on 03/01/2018.
 */
class RegularItemViewModel : PlacesType() {

    override fun getViewType(): Int {
        return ITEM_REGULAR
    }
}