package io.bratexsoft.specialtycofeecode.di.module.activity

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.fragment.*
import io.bratexsoft.specialtycofeecode.fragment.adapter.MainFragmentPagerAdapter
import io.bratexsoft.specialtycofeecode.fragment.base.AbstractFragmentDefinition
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainPresenter

@Module
class MainModule {

    @Provides
    @PerView
    fun providePresenter(): MainPresenter = MainPresenter()

    @Provides
    @PerView
    fun provideMainFragmentPagerAdapter(fragmentManager: FragmentManager): MainFragmentPagerAdapter {
        val fragments: List<AbstractFragmentDefinition> = listOf(MainMapFragment.Definition(),
                MainExploreFragment.Definition(),
                MainProfileFragment.Definition())

        return MainFragmentPagerAdapter(fragmentManager, fragments)
    }
}