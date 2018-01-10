package io.bratexsoft.specialtycofeecode.mvvm.feature.places.item

import android.databinding.BaseObservable
import android.databinding.ObservableField
import io.bratexsoft.specialtycofeecode.R

/**
 * Created by mateuszbratkowski on 03/01/2018.
 */
abstract class PlacesType : BaseObservable() {

    companion object {
        const val ITEM_REGULAR: Int = R.layout.places_adapter_item_regular
        const val ITEM_FEATURED: Int = R.layout.places_adapter_item_featured
        const val ITEM_BOTTOM: Int = R.layout.places_adapter_item_bottom
    }

    val restaurantName: ObservableField<String> = ObservableField()
    val distanceToRestaurant: ObservableField<String> = ObservableField()
    val restaurantSpecialization: ObservableField<String> = ObservableField()
    val restaurantImage: ObservableField<String> = ObservableField()

    abstract fun getViewType(): Int
}