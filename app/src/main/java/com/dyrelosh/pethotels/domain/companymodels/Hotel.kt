package com.dyrelosh.pethotels.domain.companymodels

import android.graphics.Bitmap

data class Hotel(
    val advertisementId: String,
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    val photos: Bitmap?,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean,
    val companyId: String
)