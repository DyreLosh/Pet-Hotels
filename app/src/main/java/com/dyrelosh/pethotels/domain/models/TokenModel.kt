package com.dyrelosh.pethotels.domain.models

import com.google.gson.annotations.SerializedName

data class TokenModel (
    @SerializedName("access_token")
    val token: String
)