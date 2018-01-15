package cafe.speciality.kochere.mvp.feature.places.item

import cafe.speciality.kochere.mvp.feature.places.item.definition.PlacesType
import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class RegularItem constructor(val place : Place) : PlacesType {
    override fun getViewType(): Int = PlacesType.ITEM_REGULAR
}