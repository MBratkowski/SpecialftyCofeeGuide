package io.bratexsoft.specialtycofeecode.di.module.activity

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.ActivityScope

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager
}