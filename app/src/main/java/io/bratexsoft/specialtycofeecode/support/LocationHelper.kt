package io.bratexsoft.specialtycofeecode.support

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by mateuszbratkowski on 10/01/2018.
 */
class LocationHelper constructor(private val activity: Activity) : ActivityCompat.OnRequestPermissionsResultCallback {

    interface PermissionListener {
        fun permissionGranted(location: Location)

        fun permissionDenied()
    }

    private val permissionListener: PermissionListener
    private val locationManager: LocationManager
    private val PERMISSION_REQUEST_LOCATION = 0

    init {
        locationManager = activity.applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        permissionListener = activity as PermissionListener
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_LOCATION) {
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionListener.permissionGranted(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER))
            } else {
                permissionListener.permissionDenied()
            }
        }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            permissionListener.permissionGranted(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER))
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_LOCATION)
        }
    }
}