package com.dyrelosh.pethotels.domain.companyrepository

import com.dyrelosh.pethotels.domain.companymodels.HotelCreateModel
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companymodels.TokenCompanyModel

interface HotelRepository {
    suspend fun registrationHotel(hotelCreateModel: HotelCreateModel)

    fun getToken(): String?

    fun setToken(tokenHotel: String)

    fun getEmail(): String?

    fun setEmail(emailHotel: String)

    suspend fun loginCompany(hotelLoginModel: HotelLoginModel) : String?

}