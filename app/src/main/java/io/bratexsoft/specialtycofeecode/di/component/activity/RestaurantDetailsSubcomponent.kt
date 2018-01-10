package io.bratexsoft.specialtycofeecode.di.component.activity

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.di.module.activity.RestaurantDetailsModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvvm.feature.details.RestaurantDetailsActivity

/**
 * Created by mateuszbratkowski on 07/01/2018.
 */
@PerView
@Subcomponent(modules = [(RestaurantDetailsModule::class)])
interface RestaurantDetailsSubcomponent {
    fun inject(activity: RestaurantDetailsActivity)
}