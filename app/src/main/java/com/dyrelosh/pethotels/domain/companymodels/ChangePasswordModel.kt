package com.dyrelosh.pethotels.domain.companymodels

class ChangePasswordModel (
    val email: String,
    val currentPassword: String,
    val newPassword: String
)