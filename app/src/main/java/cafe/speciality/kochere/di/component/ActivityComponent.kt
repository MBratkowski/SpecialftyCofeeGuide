package cafe.speciality.kochere.di.component

import android.content.Context
import cafe.speciality.kochere.di.component.activity.PlacesSubcomponent
import cafe.speciality.kochere.di.module.activity.ActivityModule
import cafe.speciality.kochere.di.module.activity.PlacesModule
import cafe.speciality.kochere.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun context(): Context

    fun plusModule(module: PlacesModule): PlacesSubcomponent
}