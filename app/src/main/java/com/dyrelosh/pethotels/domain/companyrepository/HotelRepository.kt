package com.dyrelosh.pethotels.domain.companyrepository

import android.graphics.Bitmap
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.*
import okhttp3.MultipartBody

//import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase

interface HotelRepository {
    suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): Boolean

    fun getToken(): String?

    fun setToken(tokenHotel: String)

    fun getEmail(): String?

    fun setEmail(emailHotel: String)

    suspend fun loginCompany(hotelLoginModel: HotelLoginModel): TokenHotelModel?

    suspend fun getAdds(token: String): List<Hotel>?

    suspend fun getAddInfo(token: String, id: String): HotelResponse

    suspend fun appendAdd(
        token: String,
        hotelAppendAddModel: HotelAppendAddModel
    ): HotelResponse

    suspend fun deleteAdd(token: String, id: String): Boolean

    suspend fun getHotelInfo(token: String): HotelInfoModel?

    suspend fun editAdCompany(
        token: String,
        addsModel: HotelAddsModel,
        id: String
    ): HotelAddsModel?

    suspend fun editProfileCompany(
        token: String,
        hotelEditModel: HotelEditModel
    ): HotelEditModel?

    suspend fun setHotelPhoto(token: String, imageUrl: String?, idAdvertisement: String): Boolean

    suspend fun getHotelPhoto(token: String, id: String): Bitmap?

    suspend fun changePassword(token: String, changePasswordModel: ChangePasswordModel): Boolean

    fun clearPreference(): Boolean

}