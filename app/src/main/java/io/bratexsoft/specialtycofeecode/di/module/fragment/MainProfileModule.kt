package io.bratexsoft.specialtycofeecode.di.module.fragment

import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainProfilePresenter

@Module
class MainProfileModule {

    @Provides
    @PerView
    fun provideMainProfilePresenter(): MainProfilePresenter = MainProfilePresenter()

}