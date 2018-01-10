package io.bratexsoft.specialtycofeecode.di.component

import dagger.Component
import io.bratexsoft.specialtycofeecode.applicaton.SpecialtyCoffeGuideApp
import io.bratexsoft.specialtycofeecode.di.module.ApplicationModule
import io.bratexsoft.specialtycofeecode.di.module.NetworkModule
import io.bratexsoft.specialtycofeecode.repository.network.RequestDefinition
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (NetworkModule::class)])
interface ApplicationComponent {
    fun inject(application: SpecialtyCoffeGuideApp)

    fun provideRequestDefinition(): RequestDefinition
}