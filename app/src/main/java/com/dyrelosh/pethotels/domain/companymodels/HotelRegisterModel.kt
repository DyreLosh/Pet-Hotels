package com.dyrelosh.pethotels.domain.companymodels

data class HotelRegisterModel (
    val inn: String,
    val hotelName: String,
    val email: String,
    val password: String,
    val userName: String,
    var roles: Array<String>
)