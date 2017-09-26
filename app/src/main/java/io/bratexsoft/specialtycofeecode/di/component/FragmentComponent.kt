package io.bratexsoft.specialtycofeecode.di.component

import dagger.Component
import io.bratexsoft.specialtycofeecode.di.component.fragment.MainExploreSubcomponent
import io.bratexsoft.specialtycofeecode.di.component.fragment.MainMapSubcomponent
import io.bratexsoft.specialtycofeecode.di.component.fragment.MainProfileSubcomponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.FragmentModule
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainExploreModule
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainMapModule
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainProfileModule
import io.bratexsoft.specialtycofeecode.di.scope.FragmentScope

@FragmentScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun plusModule(module: MainExploreModule): MainExploreSubcomponent

    fun plusModule(module: MainMapModule): MainMapSubcomponent

    fun plusModule(module: MainProfileModule): MainProfileSubcomponent
}