package io.bratexsoft.specialtycofeecode.applicaton

import android.app.Application
import io.bratexsoft.specialtycofeecode.di.component.ApplicationComponent
import io.bratexsoft.specialtycofeecode.di.component.DaggerApplicationComponent
import io.bratexsoft.specialtycofeecode.di.module.ApplicationModule

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