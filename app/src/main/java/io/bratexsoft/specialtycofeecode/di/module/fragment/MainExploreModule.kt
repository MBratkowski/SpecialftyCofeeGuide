package io.bratexsoft.specialtycofeecode.di.module.fragment

import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainExplorePresenter

@Module
class MainExploreModule {

    @Provides
    @PerView
    fun provideMainExplorePresenter(): MainExplorePresenter = MainExplorePresenter()
}