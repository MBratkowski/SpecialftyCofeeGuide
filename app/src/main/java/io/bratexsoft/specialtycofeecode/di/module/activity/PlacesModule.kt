package io.bratexsoft.specialtycofeecode.di.module.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.di.scope.PerView
import io.bratexsoft.specialtycofeecode.domain.GetPlacesUseCase
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.PlacesAdapter
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.PlacesViewModel
import io.bratexsoft.specialtycofeecode.repository.RestaurantRepository
import io.bratexsoft.specialtycofeecode.repository.remote.PlacesRepositoryRemote
import io.bratexsoft.specialtycofeecode.support.LocationHelper

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@Module
class PlacesModule {

    @PerView
    @Provides
    fun provideRepository(): RestaurantRepository = RestaurantRepository()

    @Provides
    @PerView
    fun provideLocationHelper(activity: AppCompatActivity): LocationHelper = LocationHelper(activity)

    @PerView
    @Provides
    fun provideUseCase(placesRepository: PlacesRepositoryRemote): GetPlacesUseCase {
        return GetPlacesUseCase(placesRepository)
    }

    @Provides
    @PerView
    fun provideViewModel(activity: AppCompatActivity, useCase: GetPlacesUseCase): PlacesViewModel {
        return ViewModelProviders.of(activity, PlacesViewModel.Factory(useCase))
                .get(PlacesViewModel(useCase)::class.java)
    }

    @Provides
    @PerView
    fun provideAdapter(): PlacesAdapter = PlacesAdapter()
}