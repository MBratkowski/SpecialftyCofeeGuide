package io.bratexsoft.specialtycofeecode.di.module.activity

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.ActivityScope

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    @ActivityScope
    fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    @ActivityScope
    fun provideContext(): Context = activity
}