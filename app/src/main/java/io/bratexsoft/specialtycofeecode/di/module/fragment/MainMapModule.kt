package io.bratexsoft.specialtycofeecode.di.module.fragment

import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.FragmentScope
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvp.contract.MainMapContract
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainMapPresenter

@Module
class MainMapModule {

    @Provides
    @PerView
    fun provideMainMapPresenter(): MainMapPresenter = MainMapPresenter()
}