package com.dyrelosh.pethotels.data.api.response

data class HotelResponse (
    val id: String,
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    val imageId: String,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean
)