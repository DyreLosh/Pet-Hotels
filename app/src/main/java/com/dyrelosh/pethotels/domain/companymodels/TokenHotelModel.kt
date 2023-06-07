package com.dyrelosh.pethotels.domain.companymodels

import com.google.gson.annotations.SerializedName

data class TokenHotelModel (
  //  @SerializedName("access_token")
    var token: String,
    var role: List<String>
)
