package com.dyrelosh.pethotels.domain.companymodels

import com.google.gson.annotations.SerializedName

data class TokenHotelModel (
    @SerializedName("access_token")
    var newToken: String
)



/*@SerializedName("access_token")
val token: String
)*/