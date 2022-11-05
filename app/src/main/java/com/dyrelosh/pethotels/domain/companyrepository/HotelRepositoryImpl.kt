package com.dyrelosh.pethotels.domain.companyrepository

import android.content.Context
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.preference.PreferenceStorage
import com.dyrelosh.pethotels.domain.companymodels.HotelCreateModel
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companymodels.TokenCompanyModel
import com.dyrelosh.pethotels.domain.companyusecase.LoginHotelUseCase

class HotelRepositoryImpl(context: Context) : HotelRepository {

    private val preferenceStorage = PreferenceStorage(context)

    override suspend fun registrationHotel(hotelCreateModel: HotelCreateModel) {
        ApiService.registrationHotel(hotelCreateModel)
    }

    override fun getToken(): String? {
        return preferenceStorage.accessToken
    }

    override fun setToken(token: String) {
        preferenceStorage.accessToken = token
    }

    override fun getEmail(): String? {
        return preferenceStorage.email
    }

    override fun setEmail(email: String) {
        preferenceStorage.email = email
    }

    override suspend fun loginCompany(hotelLoginModel: HotelLoginModel) : String? {
      return ApiService.loginCompany(hotelLoginModel).toString()
    }

//    override suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenCompanyModel? {
//        return ApiService.retrofit.login(userLoginModel).body()
//    }

//    fun authUser(param: LoginHotelUseCase.Param): String {
//     //TODO ApiService.users.filter { it.email == param.email && it.password == param.password }
//    return ApiService.getToken()
//    }
}