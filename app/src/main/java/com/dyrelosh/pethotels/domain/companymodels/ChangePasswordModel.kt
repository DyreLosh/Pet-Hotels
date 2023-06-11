package com.dyrelosh.pethotels.domain.companymodels

data class ChangePasswordModel (
    val email: String,
    val currentPassword: String,
    val newPassword: String
)