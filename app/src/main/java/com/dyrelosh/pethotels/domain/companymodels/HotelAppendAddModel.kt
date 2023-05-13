package com.dyrelosh.pethotels.domain.companymodels

import okhttp3.MultipartBody

data class HotelAppendAddModel (
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    val image: MultipartBody.Part? = null,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean
)