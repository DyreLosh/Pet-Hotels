package com.dyrelosh.pethotels.extensions

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.FragmentActivity
import com.github.dhaval2404.imagepicker.ImagePicker


private const val FILE_PATH_KEY = "extra.file_path"
private const val MIME_TYPE_JPG = "image/jpg"
private const val MIME_TYPE_JPEG = "image/jpeg"
private const val MIME_TYPE_PNG = "image/png"
private const val MAX_IMAGE_SIZE = 3072


fun FragmentActivity.handleImagePickerResult(
    result: ActivityResult,
    needPath: Boolean = false,
    onSuccess: (String) -> Unit = { },
    onCancel: () -> Unit = { },
    onFailure: () -> Unit = { },
) {
    if (result.resultCode == Activity.RESULT_OK) {
        val receivedString =
            if (needPath) result.data?.extras?.getString(FILE_PATH_KEY) else result.data?.data?.toString()
        receivedString?.let { string ->
            onSuccess(string)
        } ?: run {
            onFailure()
        }
    } else {
        onCancel()
    }
}

fun FragmentActivity.pickImage(
    launcher: ActivityResultLauncher<Intent>,
    needCrop: Boolean = false
) {
    ImagePicker
        .with(this)
        .galleryMimeTypes(
            mimeTypes = arrayOf(
                MIME_TYPE_JPG,
                MIME_TYPE_JPEG,
                MIME_TYPE_PNG
            )
        )
        .compress(MAX_IMAGE_SIZE)
        .apply { if (needCrop) cropSquare() }
        .createIntent(launcher::launch)
}