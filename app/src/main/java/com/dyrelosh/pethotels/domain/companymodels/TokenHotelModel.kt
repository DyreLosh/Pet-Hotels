package com.dyrelosh.pethotels.domain.companymodels

import com.google.gson.annotations.SerializedName

data class TokenHotelModel (
    var token: String,
    var role: Array<String>
)
