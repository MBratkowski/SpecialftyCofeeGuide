package io.bratexsoft.specialtycofeecode.di.component.fragment

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainExploreModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.fragment.MainExploreFragment

@PerView
@Subcomponent(modules = arrayOf(MainExploreModule::class))
interface MainExploreSubcomponent {
    fun inject(fragment: MainExploreFragment)
}