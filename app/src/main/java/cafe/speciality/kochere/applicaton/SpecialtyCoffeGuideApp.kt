package cafe.speciality.kochere.applicaton

import android.app.Application
import com.facebook.stetho.Stetho

class SpecialtyCoffeGuideApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        SpecialtyCoffeGuideInjector.INSTANCE.app = this
        SpecialtyCoffeGuideInjector.INSTANCE.appComponent.inject(this)
    }
}