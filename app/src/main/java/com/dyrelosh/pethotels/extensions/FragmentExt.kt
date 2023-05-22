package com.dyrelosh.pethotels.extensions

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

/** Проверка разрешения на [Manifest.permission.WRITE_EXTERNAL_STORAGE].
 * Если нет разрешения, то появится системный диалог для дачи разрешения*/
fun Fragment.isStoragePermissionGranted(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
        if (ActivityCompat.checkSelfPermission(
                activity as Context, Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Log.v(ContentValues.TAG, "Permission is granted")
            true
        } else {
            Log.v(ContentValues.TAG, "Permission is revoked")
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1
            )
            false
        }
    } else {
        // Permission is automatically granted on 32 < sdk < 23 upon installation
        Log.v(ContentValues.TAG, "Permission is granted")
        true
    }
}