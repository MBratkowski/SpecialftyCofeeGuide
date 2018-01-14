package cafe.speciality.kochere.di.module.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.R
import dagger.Module
import dagger.Provides
import cafe.speciality.kochere.di.scope.PerView
import cafe.speciality.kochere.domain.GetPlacesUseCase
import cafe.speciality.kochere.mvvm.feature.places.PlacesViewModel
import cafe.speciality.kochere.repository.model.Constant
import cafe.speciality.kochere.repository.remote.PlacesRepositoryRemote
import cafe.speciality.kochere.support.LocationHelper

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@Module
class PlacesModule {
    
    @Provides
    @PerView
    fun provideLocationHelper(activity: AppCompatActivity): LocationHelper = LocationHelper(activity)

    @PerView
    @Provides
    fun provideResources(activity: AppCompatActivity): HashMap<String, String> {
        val resources = activity.resources
        val hashMap: HashMap<String, String> = HashMap()
        hashMap[Constant.TYPE_AEROPRESS] = resources.getString(R.string.specialization_aero_press)
        hashMap[Constant.TYPE_ESPRESSO] = resources.getString(R.string.specialization_espresso)
        hashMap[Constant.TYPE_CHEMEX] = resources.getString(R.string.specialization_chemex)
        hashMap[Constant.TYPE_COLD_BREW] = resources.getString(R.string.specialization_cold_brew)
        hashMap[Constant.TYPE_DRIP] = resources.getString(R.string.specialization_drip)
        hashMap[Constant.TYPE_SYPHON] = resources.getString(R.string.specialization_syphon)
        return hashMap
    }

    @PerView
    @Provides
    fun provideUseCase(placesRepository: PlacesRepositoryRemote): GetPlacesUseCase {
        return GetPlacesUseCase(placesRepository)
    }

    @Provides
    @PerView
    fun provideViewModel(activity: AppCompatActivity, useCase: GetPlacesUseCase, map: HashMap<String, String>): PlacesViewModel {
        return ViewModelProviders.of(activity, PlacesViewModel.Factory(useCase, map))
                .get(PlacesViewModel(useCase, map)::class.java)
    }
}