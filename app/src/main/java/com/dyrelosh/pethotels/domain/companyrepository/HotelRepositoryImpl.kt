package com.dyrelosh.pethotels.domain.companyrepository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.preference.PreferenceStorage
import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel

class HotelRepositoryImpl(context: Context) : HotelRepository {

    private val preferenceStorage = PreferenceStorage(context)

    override suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): TokenHotelModel? {
       return ApiService.retrofit.registration(hotelRegisterModel).body()
    }

    override fun getToken(): String? {
        return preferenceStorage.accessToken
    }

    override fun setToken(tokenHotel: String) {
        preferenceStorage.accessToken = tokenHotel
    }

    override fun getEmail(): String? {
        return preferenceStorage.email
    }

    override fun setEmail(emailHotel: String) {
        preferenceStorage.email = emailHotel
    }

    override suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenHotelModel? {
      return ApiService.retrofit.login(hotelLoginModel).body()
    }
    override suspend fun getHotelInfo(token: String): HotelInfoModel? {
        return ApiService.retrofit.getUserInfo("Bearer $token").body()
    }

    override suspend fun editProfileCompany(token: String, hotelInfoModel: HotelInfoModel): HotelInfoModel? {
        return ApiService.retrofit.editProfileCompany("Bearer $token", hotelInfoModel).body()
    }

//    override suspend fun setUserPhoto(token: String, image: MultipartBody.Part): Int {
//        return ApiService.retrofit.setUserPhoto("Bearer $token", image).code()
//    }
//
//    override suspend fun getUserPhoto(token: String, id: String): Bitmap? {
//        return BitmapFactory.decodeStream(ApiService.retrofit.getUserPhoto("Bearer $token", id).body()!!.byteStream())
//    }

    override suspend fun getAddInfo(token: String, id: String): HotelAddsModel {
        return ApiService.retrofit.getAddInfo("Bearer $token", id).body()!!
    }

    override suspend fun getAdds(token: String): List<HotelAddsModel>? {
        return ApiService.retrofit.getAdds("Bearer $token").body()
    }

    override suspend fun appendAdd(token: String, hotelAppendAddModel: HotelAppendAddModel): Boolean {
        return ApiService.retrofit.appendAdd("Bearer $token", hotelAppendAddModel).isSuccessful
    }
//
//    override suspend fun deleteAdd(token: String, id: String): Boolean {
//        return ApiService.retrofit.deleteTodos("Bearer $token", id).isSuccessful
//    }

//    override suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenCompanyModel? {
//        return ApiService.retrofit.login(userLoginModel).body()
//    }

//    fun authUser(param: LoginHotelUseCase.Param): String {
//     //TODO ApiService.users.filter { it.email == param.email && it.password == param.password }
//    return ApiService.getToken()
//    }

    override suspend fun changeUserPassword(token: String, changePasswordModel: ChangePasswordModel): Boolean {
        return ApiService.retrofit.changePassword("Bearer $token", changePasswordModel).isSuccessful
    }

    override suspend fun userRegister(registerModel: UserRegisterModel): Boolean {
        return ApiService.retrofit.userRegister(registerModel).isSuccessful
    }

    override suspend fun getHotels(token: String): List<UserHotelModel>? {
        return ApiService.retrofit.getHotels("Bearer $token").body()
    }

    override suspend fun getOneHotel(token: String, id: String): UserHotelModel {
        return ApiService.retrofit.getHotelsID("Bearer $token", id).body()!!
    }


    override suspend fun changeUserData() {
        TODO("Not yet implemented")
    }

    override suspend fun getFavourites(userHotelModel: UserHotelModel): UserHotelModel {
        TODO("Not yet implemented")
    }

    override suspend fun getUserInfoFun(token: String): UserInfoModel {
        return ApiService.retrofit.getUserInfoFun("Bearer $token").body()!!
    }

    override fun setPassword(password: String) {
        preferenceStorage.password == password
    }

    override fun getPassword(): String? {
        return preferenceStorage.password
    }

    override suspend fun getHotelPhotoUser(token: String, id: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(
                ApiService.retrofit.getHotelPhoto("Bearer $token", id).body()!!.byteStream()
            )
        } catch (e: Exception) {
            null
        }
    }

}