package cafe.speciality.kochere.support

import android.Manifest
import android.support.v7.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

/**
 * Created by mateuszbratkowski on 14/01/2018.
 */
class LocationPermissionSupport constructor(val activity: AppCompatActivity) {

    interface Callback {
        fun permissionAccess()

        fun permissionDeclined()
    }

    fun checkPermission(callback: Callback) {
        Dexter.withActivity(activity).withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        if (report?.grantedPermissionResponses!!.isEmpty()) {

                        } else {
                            callback.permissionAccess()
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {
                        callback.permissionDeclined()
                    }

                }).check()
    }
}