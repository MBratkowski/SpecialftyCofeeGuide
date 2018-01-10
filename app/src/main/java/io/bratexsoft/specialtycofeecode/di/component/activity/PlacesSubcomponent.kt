package io.bratexsoft.specialtycofeecode.di.component.activity

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.di.module.activity.PlacesModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.PlacesActivity

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@PerView
@Subcomponent(modules = [(PlacesModule::class)])
interface PlacesSubcomponent {
    fun inject(activity: PlacesActivity)
}