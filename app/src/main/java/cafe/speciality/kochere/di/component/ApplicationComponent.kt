package cafe.speciality.kochere.di.component

import dagger.Component
import cafe.speciality.kochere.applicaton.SpecialtyCoffeGuideApp
import cafe.speciality.kochere.di.module.ApplicationModule
import cafe.speciality.kochere.di.module.NetworkModule
import cafe.speciality.kochere.repository.network.RequestDefinition
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (NetworkModule::class)])
interface ApplicationComponent {
    fun inject(application: SpecialtyCoffeGuideApp)

    fun provideRequestDefinition(): RequestDefinition
}