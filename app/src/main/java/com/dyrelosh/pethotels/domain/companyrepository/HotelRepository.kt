package com.dyrelosh.pethotels.domain.companyrepository

import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
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


    suspend fun userRegister(registerModel: UserRegisterModel): TokenModel?

    suspend fun getHotels(token: String) : List<UserHotelModel>?

    suspend fun getOneHotel(token: String, id: String) : UserHotelModel

    suspend fun changePassword()

    suspend fun changeUserData()

    suspend fun getFavourites(userHotelModel: UserHotelModel): UserHotelModel
}