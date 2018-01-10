package io.bratexsoft.specialtycofeecode.di.module.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.mvvm.feature.details.RestaurantDetailsViewModel

/**
 * Created by mateuszbratkowski on 07/01/2018.
 */
@Module
class RestaurantDetailsModule {

    @Provides
    @PerView
    fun provideViewModel(activity: AppCompatActivity): RestaurantDetailsViewModel {
        return ViewModelProviders.of(activity).get(RestaurantDetailsViewModel::class.java)
    }
}