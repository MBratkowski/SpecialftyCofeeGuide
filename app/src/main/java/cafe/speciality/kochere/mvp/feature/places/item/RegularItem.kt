package cafe.speciality.kochere.mvp.feature.places.item

import cafe.speciality.kochere.mvp.feature.places.item.definition.DataContent
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType
import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class RegularItem constructor(override val data: Place) : PlaceViewType, DataContent<Place> {

    override fun getViewType(): Int = PlaceViewType.ITEM_REGULAR
}