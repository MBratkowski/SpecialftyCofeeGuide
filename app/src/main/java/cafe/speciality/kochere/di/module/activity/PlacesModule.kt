package cafe.speciality.kochere.di.module.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.R
import cafe.speciality.kochere.di.scope.PerView
import cafe.speciality.kochere.domain.UseCaseFactory
import cafe.speciality.kochere.mvp.feature.places.PlacesAdapter
import cafe.speciality.kochere.mvp.feature.places.PlacesPresenter
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.repository.model.Constant
import cafe.speciality.kochere.support.LocationPermissionSupport
import cafe.speciality.kochere.support.LocationProvider
import dagger.Module
import dagger.Provides

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@Module
class PlacesModule {

    @PerView
    @Provides
    fun provideLocationProvider(context: Context): LocationProvider {
        return LocationProvider(context)
    }

    @PerView
    @Provides
    fun provideLocationPermissionSupport(context: Context): LocationPermissionSupport {
        return LocationPermissionSupport(context)
    }

    @PerView
    @Provides
    fun provideResources(context: Context): HashMap<String, String> {
        val resources = context.resources
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
    fun providePresenter(useCaseFactory: UseCaseFactory,
                         locationPermissionSupport: LocationPermissionSupport,
                         locationProvider: LocationProvider,
                         stringResources: HashMap<String, String>): PlacesContract.Presenter {
        return PlacesPresenter(useCaseFactory, locationPermissionSupport, locationProvider, stringResources)
    }

    @PerView
    @Provides
    fun provideAdapter(presenter: PlacesContract.Presenter): PlacesAdapter {
        return PlacesAdapter(presenter)
    }

}