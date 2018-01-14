package cafe.speciality.kochere.mvvm.feature.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.mvvm.feature.places.PlacesActivity
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

/**
 * Created by mateuszbratkowski on 14/01/2018.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        PlacesActivity.startActivity(this)
        finish()
    }
}