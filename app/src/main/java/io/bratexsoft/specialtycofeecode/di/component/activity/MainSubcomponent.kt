package io.bratexsoft.specialtycofeecode.di.component.activity

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.activity.MainActivity
import io.bratexsoft.specialtycofeecode.di.module.activity.MainModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView

@PerView
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainSubcomponent {
    fun inject(activity: MainActivity)
}