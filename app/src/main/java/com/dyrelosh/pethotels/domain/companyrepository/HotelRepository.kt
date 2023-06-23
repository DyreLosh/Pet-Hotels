package com.dyrelosh.pethotels.domain.companyrepository

import android.graphics.Bitmap
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.utils.ApiResult
import okhttp3.ResponseBody

//import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase

interface HotelRepository {

    suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): Int

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

    suspend fun setHotelPhoto(token: String, imageUrl: String?, idAdvertisement: String): Bitmap?

    suspend fun getHotelPhoto(token: String, id: String): Bitmap?

    suspend fun changePassword(token: String, changePasswordModel: ChangePasswordModel): Boolean

    fun clearPreference(): Boolean

    //suspend fun getUserPhoto(token: String, id: String): Bitmap?


    suspend fun userRegister(registerModel: UserRegisterModel): Int

    suspend fun getHotels(token: String) : List<Hotel>?

    suspend fun getOneHotel(token: String, id: String) : UserHotelModel

    suspend fun changeUserPassword(token: String, changePasswordModel: ChangePasswordModel): Boolean

    suspend fun changeUserEmail(token: String, id: String, email: String): Boolean

    suspend fun changeUserName(token: String, id: String, userName: String): Boolean


    suspend fun getUserInfoFun(token: String) : UserInfoModel

    fun getPassword(): String?

    fun setPassword(password: String)

    suspend fun getHotelPhotoUser(token: String, id: String): Bitmap?

    fun setLoginRole(role: String)

    suspend fun getCompanyForId(id: String) : HotelInfoModel


}