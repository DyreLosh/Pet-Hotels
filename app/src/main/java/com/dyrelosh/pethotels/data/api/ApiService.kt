package com.dyrelosh.pethotels.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit: ApiPetHotels = Retrofit.Builder()
        .baseUrl("http://185.139.69.220/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiPetHotels::class.java)
}
