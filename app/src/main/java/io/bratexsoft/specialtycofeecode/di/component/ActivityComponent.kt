package io.bratexsoft.specialtycofeecode.di.component

import android.content.Context
import dagger.Component
import io.bratexsoft.specialtycofeecode.di.component.activity.PlacesSubcomponent
import io.bratexsoft.specialtycofeecode.di.module.activity.ActivityModule
import io.bratexsoft.specialtycofeecode.di.module.activity.PlacesModule
import io.bratexsoft.specialtycofeecode.di.scope.ActivityScope

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun context(): Context

    fun plusModule(module: PlacesModule): PlacesSubcomponent
}