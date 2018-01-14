package cafe.speciality.kochere.applicaton

import android.app.Application
import cafe.speciality.kochere.di.component.ApplicationComponent
import cafe.speciality.kochere.di.component.DaggerApplicationComponent
import cafe.speciality.kochere.di.module.ApplicationModule

enum class SpecialtyCoffeGuideInjector {
    INSTANCE;

    lateinit var app: Application

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(app))
                .build()
    }
}