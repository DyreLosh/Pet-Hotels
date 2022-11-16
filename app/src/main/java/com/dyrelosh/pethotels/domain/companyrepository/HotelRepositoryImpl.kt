package com.dyrelosh.pethotels.domain.companyrepository

import android.content.Context
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.preference.PreferenceStorage
import com.dyrelosh.pethotels.domain.companymodels.*

class HotelRepositoryImpl(context: Context) : HotelRepository {

    private val preferenceStorage = PreferenceStorage(context)

    override suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel) {
        ApiService.registrationHotel(hotelRegisterModel)
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
    override suspend fun getHotelInfo(token: String): HotelInfoModel? {
        return ApiService.retrofit.getUserInfo("Bearer $token").body()
    }

//    override suspend fun setUserPhoto(token: String, image: MultipartBody.Part): Int {
//        return ApiService.retrofit.setUserPhoto("Bearer $token", image).code()
//    }
//
//    override suspend fun getUserPhoto(token: String, id: String): Bitmap? {
//        return BitmapFactory.decodeStream(ApiService.retrofit.getUserPhoto("Bearer $token", id).body()!!.byteStream())
//    }

    override suspend fun getAdds(token: String): List<HotelAddsModel>? {
        return ApiService.retrofit.getTodos("Bearer $token").body()
    }

    override suspend fun appendAdd(token: String, hotelAppendAddModel: HotelAppendAddModel): Boolean {
        return ApiService.retrofit.createTodos("Bearer $token", hotelAppendAddModel).isSuccessful
    }

    override suspend fun deleteAdd(token: String, id: String): Boolean {
        return ApiService.retrofit.deleteTodos("Bearer $token", id).isSuccessful
    }

//    override suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenCompanyModel? {
//        return ApiService.retrofit.login(userLoginModel).body()
//    }

//    fun authUser(param: LoginHotelUseCase.Param): String {
//     //TODO ApiService.users.filter { it.email == param.email && it.password == param.password }
//    return ApiService.getToken()
//    }
}