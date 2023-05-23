package com.dyrelosh.pethotels.domain.repository

import android.content.Context
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.preference.PreferenceStorage
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel

class UserRepositoryImpl(context: Context) : UserRepository {

    private val preferenceStorage = PreferenceStorage(context)

    override fun getUserToken(): String? {
        return preferenceStorage.accessToken
    }

    override fun setUserToken(tokenHotel: String) {
        preferenceStorage.accessToken = tokenHotel
    }

    override fun getUserEmail(): String? {
        return preferenceStorage.email
    }

    override fun setUserEmail(emailHotel: String) {
        preferenceStorage.email = emailHotel
    }

    override suspend fun userRegister(registerModel: UserRegisterModel): TokenModel? {
        return ApiService.retrofit.userRegister(registerModel).body()
    }

    override suspend fun getHotels(token: String): List<UserHotelModel>? {
        return ApiService.retrofit.getHotels("Bearer $token").body()
    }

    override suspend fun getOneHotel(token: String, id: String): UserHotelModel {
        return ApiService.retrofit.getHotelsID("Bearer $token", id).body()!!
    }


}