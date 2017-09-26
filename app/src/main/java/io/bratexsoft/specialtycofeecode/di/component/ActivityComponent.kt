package io.bratexsoft.specialtycofeecode.di.component

import dagger.Component
import io.bratexsoft.specialtycofeecode.di.component.activity.MainSubcomponent
import io.bratexsoft.specialtycofeecode.di.module.activity.ActivityModule
import io.bratexsoft.specialtycofeecode.di.module.activity.MainModule
import io.bratexsoft.specialtycofeecode.di.scope.ActivityScope

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun plusModule(module: MainModule): MainSubcomponent
}