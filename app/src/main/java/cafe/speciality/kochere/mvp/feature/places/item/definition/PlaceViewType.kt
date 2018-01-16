package cafe.speciality.kochere.mvp.feature.places.item.definition

import cafe.speciality.kochere.R

/**
 * Created by mateuszbratkowski on 03/01/2018.
 */
interface PlaceViewType {

    companion object {
        const val ITEM_REGULAR: Int = R.layout.places_adapter_item_regular
        const val ITEM_FEATURED: Int = R.layout.places_adapter_item_featured
        const val ITEM_BOTTOM: Int = R.layout.places_adapter_item_bottom
    }

    fun getViewType(): Int
}