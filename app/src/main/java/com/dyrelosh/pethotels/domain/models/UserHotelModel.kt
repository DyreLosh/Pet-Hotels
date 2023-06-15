package com.dyrelosh.pethotels.domain.models

data class UserHotelModel (
    val advertisementId: String,
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean,
    val companyId: String,
    val photos: List<String>
        )