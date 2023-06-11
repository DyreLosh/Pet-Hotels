package com.dyrelosh.pethotels.domain.companyrepository

import android.graphics.Bitmap
import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel

//import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase

interface HotelRepository {
    suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): TokenHotelModel?

    fun getToken(): String?

    fun setToken(tokenHotel: String)

    fun getEmail(): String?

    fun setEmail(emailHotel: String)

    suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenHotelModel?

    suspend fun getAdds(token: String): List<HotelAddsModel>?

    suspend fun getAddInfo(token: String, id: String) : HotelAddsModel

    suspend fun appendAdd(
        token: String,
        hotelAppendAddModel: HotelAppendAddModel
    ): Boolean

//    suspend fun deleteAdd(token: String, id: String): Boolean
//
    suspend fun getHotelInfo(token: String): HotelInfoModel?

    suspend fun editProfileCompany(
        token: String,
        hotelInfoModel: HotelInfoModel
    ): HotelInfoModel?

    //suspend fun setUserPhoto(token: String, image: MultipartBody.Part): Int

    //suspend fun getUserPhoto(token: String, id: String): Bitmap?


    suspend fun userRegister(registerModel: UserRegisterModel): Boolean

    suspend fun getHotels(token: String) : List<UserHotelModel>?

    suspend fun getOneHotel(token: String, id: String) : UserHotelModel

    suspend fun changeUserPassword(token: String, changePasswordModel: ChangePasswordModel): Boolean

    suspend fun changeUserData()

    suspend fun getFavourites(userHotelModel: UserHotelModel): UserHotelModel

    suspend fun getUserInfoFun(token: String) : UserInfoModel

    fun getPassword(): String?

    fun setPassword(password: String)

    suspend fun getHotelPhotoUser(token: String, id: String): Bitmap?


}