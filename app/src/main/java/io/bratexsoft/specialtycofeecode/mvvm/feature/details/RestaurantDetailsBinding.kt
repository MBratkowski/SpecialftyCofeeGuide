package io.bratexsoft.specialtycofeecode.mvvm.feature.details

import android.databinding.ObservableArrayList
import android.databinding.ObservableField

/**
 * Created by mateuszbratkowski on 07/01/2018.
 */
class RestaurantDetailsBinding {

    val name: ObservableField<String> = ObservableField()
    val address: ObservableField<String> = ObservableField()
    val description: ObservableField<String> = ObservableField()
    val expertReview: ObservableField<String> = ObservableField()
    val popularity: ObservableField<String> = ObservableField()
    val photos: ObservableArrayList<String> = ObservableArrayList()

}