package com.dyrelosh.pethotels.domain.models

data class UserInfoModel(
    val id: String,
    val inn: String,
    val email: String,
    val hotelName: String,
    val userName: String
)
