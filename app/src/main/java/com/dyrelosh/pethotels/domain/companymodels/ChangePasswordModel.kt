package com.dyrelosh.pethotels.domain.companymodels

data class ChangePasswordModel (
    val email: String,
    val currentPassword: String,
    val newPassword: String
)

data class ChangeEmailModel (
    val id: String,
    val email: String
)

data class ChangeUserNameModel (
    val id: String,
    val userName: String,
)