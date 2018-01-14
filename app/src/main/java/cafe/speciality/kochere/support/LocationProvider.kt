package cafe.speciality.kochere.support

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlin.properties.Delegates

/**
 * Created by mateuszbratkowski on 14/01/2018.
 */
class LocationProvider constructor(private val activity: AppCompatActivity,
                                   private val locationPermissionSupport: LocationPermissionSupport,
                                   private val locationListener: LocationChangeListener) : LocationPermissionSupport.Callback {

    interface LocationChangeListener {
        fun onLocationChanged(location: Location)
    }

    private val locationManager: LocationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    private var location: Location by Delegates.observable(
            initialValue = Location(""),
            onChange = { property, oldValue, newValue ->
                locationListener.onLocationChanged(location)
            }
    )

    @SuppressLint("MissingPermission")
    override fun permissionAccess() {
        location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
    }

    override fun permissionDeclined() {
        AlertDialog.Builder(activity)
                .setTitle("Some title")
                .setMessage("Are you stupid")
                .create()
                .show()
    }

    fun requestLocation() {
        locationPermissionSupport.checkPermission(this)
    }
}