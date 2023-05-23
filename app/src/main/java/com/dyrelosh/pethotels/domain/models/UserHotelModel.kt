package com.dyrelosh.pethotels.domain.models

data class UserHotelModel (
    val id: String,
    val name: String,
    val city: String,
    val address: String,
    val number: String,
    val description: String,
    //  val photoHotel: String,
    val cat: Boolean,
    val rodent: Boolean,
    val dog: Boolean,
    val other: Boolean
        )