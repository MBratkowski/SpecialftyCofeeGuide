package io.bratexsoft.specialtycofeecode.di.component.fragment

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainMapModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.fragment.MainMapFragment

@PerView
@Subcomponent(modules = arrayOf(MainMapModule::class))
interface MainMapSubcomponent {
    fun inject(fragment: MainMapFragment)
}
