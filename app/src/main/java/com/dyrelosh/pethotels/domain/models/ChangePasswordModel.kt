package com.dyrelosh.pethotels.domain.models

data class ChangePasswordModel(
    val email: String,
    val currentPassword: String,
    val newPassword: String
)
