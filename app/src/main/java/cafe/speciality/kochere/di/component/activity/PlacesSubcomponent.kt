package cafe.speciality.kochere.di.component.activity

import dagger.Subcomponent
import cafe.speciality.kochere.di.module.activity.PlacesModule
import cafe.speciality.kochere.di.scope.PerView
import cafe.speciality.kochere.mvp.feature.places.PlacesActivity

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@PerView
@Subcomponent(modules = [(PlacesModule::class)])
interface PlacesSubcomponent {
    fun inject(activity: PlacesActivity)
}