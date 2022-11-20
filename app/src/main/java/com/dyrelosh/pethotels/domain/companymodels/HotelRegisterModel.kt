package com.dyrelosh.pethotels.domain.companymodels

data class HotelRegisterModel (
    val INN: String,
    val name: String,
    val email: String,
    val password: String
)