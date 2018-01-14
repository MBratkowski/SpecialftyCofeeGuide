package cafe.speciality.kochere.mvvm.feature.places.item

import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 03/01/2018.
 */
class RegularItemViewModel constructor(val place: Place) : PlacesType() {

    override fun getViewType(): Int {
        return ITEM_REGULAR
    }
}