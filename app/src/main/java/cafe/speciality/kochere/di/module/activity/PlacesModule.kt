package cafe.speciality.kochere.di.module.activity

import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.di.scope.PerView
import cafe.speciality.kochere.mvp.feature.places.PlacesActivity
import cafe.speciality.kochere.mvp.feature.places.PlacesPresenter
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.repository.model.Constant
import cafe.speciality.kochere.support.LocationPermissionSupport
import dagger.Module
import dagger.Provides

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@Module
class PlacesModule {

    @PerView
    @Provides
    fun providePlacesActivity(activity: AppCompatActivity): PlacesActivity {
        return activity as PlacesActivity
    }

    @PerView
    @Provides
    fun provideLocationPermissionSupport(activity: AppCompatActivity): LocationPermissionSupport {
        return LocationPermissionSupport(activity)
    }

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
    fun providePresenter(): PlacesContract.Presenter {
        return PlacesPresenter()
    }

}