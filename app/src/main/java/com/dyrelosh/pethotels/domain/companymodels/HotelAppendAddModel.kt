package com.dyrelosh.pethotels.domain.companymodels

data class HotelAppendAddModel (
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    val imageId: String? = null,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean
)