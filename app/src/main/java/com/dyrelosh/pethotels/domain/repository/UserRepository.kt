package com.dyrelosh.pethotels.domain.repository

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel

interface UserRepository {

    fun getUserToken(): String?

    fun setUserToken(tokenHotel: String)

    fun getUserEmail(): String?

    fun setUserEmail(emailHotel: String)

    suspend fun userRegister(registerModel: UserRegisterModel): TokenModel?

    suspend fun getHotels(token: String) : List<UserHotelModel>?

    suspend fun getOneHotel(token: String, id: String) : UserHotelModel
}