package com.dyrelosh.pethotels.data.api.response

data class HotelResponse (
    val advertisementId: String,
    val name: String,
    val city: String,
    val address: String,
    val description: String,
    val number: String,
    val cat: Boolean,
    val dog: Boolean,
    val rodent: Boolean,
    val other: Boolean,
    val companyId: String,
    val photos: List<String>
)