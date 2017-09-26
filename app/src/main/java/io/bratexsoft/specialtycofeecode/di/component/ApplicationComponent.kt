package io.bratexsoft.specialtycofeecode.di.component

import dagger.Component
import io.bratexsoft.specialtycofeecode.applicaton.SpecialtyCoffeGuideApp
import io.bratexsoft.specialtycofeecode.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: SpecialtyCoffeGuideApp)
}