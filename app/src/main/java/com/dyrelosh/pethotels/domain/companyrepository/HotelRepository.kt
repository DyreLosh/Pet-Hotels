package com.dyrelosh.pethotels.domain.companyrepository

import android.graphics.Bitmap
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.*
import okhttp3.MultipartBody

//import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase

interface HotelRepository {
    suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): TokenHotelModel?

    fun getToken(): String?

    fun setToken(tokenHotel: String)

    fun getEmail(): String?

    fun setEmail(emailHotel: String)

    suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenHotelModel?

    suspend fun getAdds(token: String): List<Hotel>?

    suspend fun getAddInfo(token: String, id: String) : HotelAddsModel

    suspend fun appendAdd(
        token: String,
        hotelAppendAddModel: HotelAppendAddModel
    ): Hotel

    suspend fun deleteAdd(token: String, id: String): Boolean

    suspend fun getHotelInfo(token: String): HotelInfoModel?

    suspend fun editAdCompany(
        token: String,
        addsModel: HotelAddsModel
    ): HotelAddsModel?

    suspend fun editProfileCompany(
        token: String,
        hotelInfoModel: HotelInfoModel
    ): HotelInfoModel?

    suspend fun setHotelPhoto(token: String, image: MultipartBody.Part, id: String): Int

    suspend fun getHotelPhoto(token: String, id: String): Bitmap?
}