package io.bratexsoft.specialtycofeecode.di.component.fragment

import dagger.Subcomponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainProfileModule
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.fragment.MainProfileFragment

@PerView
@Subcomponent(modules = arrayOf(MainProfileModule::class))
interface MainProfileSubcomponent {
    fun inject(fragment: MainProfileFragment)
}