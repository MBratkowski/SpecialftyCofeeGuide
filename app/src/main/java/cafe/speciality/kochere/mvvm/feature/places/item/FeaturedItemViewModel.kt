package cafe.speciality.kochere.mvvm.feature.places.item

import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 06/01/2018.
 */
class FeaturedItemViewModel constructor(val place: Place) : PlacesType() {

    override fun getViewType(): Int = ITEM_FEATURED

}