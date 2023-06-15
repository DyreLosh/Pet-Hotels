package com.dyrelosh.pethotels.domain.companyrepository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.extensions.toMultipartPart
import java.io.File
import java.lang.Exception

class HotelRepositoryImpl(context: Context) : HotelRepository {

    private val preferenceStorage = PreferenceStorage(context)

    companion object {
        private const val AVATAR_PART_NAME = "file"
    }

    override suspend fun registrationHotel(hotelRegisterModel: HotelRegisterModel): Boolean {
        return ApiService.retrofit.registration(hotelRegisterModel).isSuccessful
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

    override suspend fun editProfileCompany(
        token: String,
        hotelEditModel: HotelEditModel
    ): HotelEditModel? {
        return ApiService.retrofit.editProfileCompany("Bearer $token", hotelEditModel).body()
    }

    override suspend fun editAdCompany(
        token: String,
        addsModel: HotelAddsModel,
        id: String
    ): HotelAddsModel? {
        return ApiService.retrofit.editAdCompany("Bearer $token", addsModel, id).body()
    }

//    override suspend fun setHotelPhoto(token: String, imageUrl: String?, idAdvertisement: String): Boolean {
//        return ApiService.retrofit.setHotelPhoto(
//            "Bearer $token", idAdvertisement, File(imageUrl).toMultipartPart(AVATAR_PART_NAME)
//        ).isSuccessful
//    }

    override suspend fun setHotelPhoto(
        token: String,
        imageUrl: String?,
        idAdvertisement: String
    ): Bitmap? {
        return try {
            BitmapFactory.decodeStream(
                ApiService.retrofit.setHotelPhoto(
                    "Bearer $token",
                    idAdvertisement,
                    File(imageUrl).toMultipartPart(AVATAR_PART_NAME)
                ).body()!!.byteStream()
            )
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getHotelPhoto(token: String, id: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(
                ApiService.retrofit.getHotelPhoto("Bearer $token", id).body()!!.byteStream()
            )
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAddInfo(token: String, id: String): HotelResponse {
        return ApiService.retrofit.getAddInfo("Bearer $token", id).body()!!
    }

    override suspend fun getAdds(token: String): List<Hotel>? {
        return ApiService.retrofit.getAdds("Bearer $token").body()!!
            ?.map {
                hotelResponseToModel(
                    it,
                    it.photos.map { id ->
                        getHotelPhoto(token, id)
                    }
                )
            }
    }

    override suspend fun appendAdd(
        token: String,
        hotelAppendAddModel: HotelAppendAddModel
    ): HotelResponse {
        return ApiService.retrofit.appendAdd("Bearer $token", hotelAppendAddModel).body()!!
    }

    override suspend fun changePassword(
        token: String,
        changePasswordModel: ChangePasswordModel
    ): Boolean {
        return ApiService.retrofit.changePassword("Bearer $token", changePasswordModel).isSuccessful
    }


    override suspend fun deleteAdd(token: String, id: String): Boolean {
        return ApiService.retrofit.deleteAdd("Bearer $token", id).isSuccessful
    }

    override fun clearPreference(): Boolean {
        preferenceStorage.clearPreference()
        return true
    }


//    fun authUser(param: LoginHotelUseCase.Param): String {
//     //TODO ApiService.users.filter { it.email == param.email && it.password == param.password }
//    return ApiService.getToken()
//    }

    override suspend fun changeUserPassword(
        token: String,
        changePasswordModel: ChangePasswordModel
    ): Boolean {
        return ApiService.retrofit.changePassword("Bearer $token", changePasswordModel).isSuccessful
    }

    override suspend fun changeUserEmail(
        token: String,
        changeEmailModel: ChangeEmailModel
    ): Boolean {
        return ApiService.retrofit.changeUserEmail(
            "Bearer $token",
            changeEmailModel.id,
            changeEmailModel.email
        ).isSuccessful
    }

    override suspend fun changeUserName(
        token: String,
        changeUserNameModel: ChangeUserNameModel
    ): Boolean {
        return ApiService.retrofit.changeUserName(
            "Bearer $token",
            changeUserNameModel.id,
            changeUserNameModel.userName
        ).isSuccessful
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


    override suspend fun getUserInfoFun(token: String): UserInfoModel {
        return ApiService.retrofit.getUserInfoFun("Bearer $token").body()!!
    }

    override fun setPassword(password: String) {
        preferenceStorage.password = password
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

    private fun hotelResponseToModel(response: HotelResponse, hotelPhoto: List<Bitmap?>): Hotel {
        return Hotel(
            advertisementId = response.advertisementId,
            name = response.name,
            city = response.city,
            address = response.address,
            number = response.number,
            description = response.description,
            photos = hotelPhoto,
            cat = response.cat,
            rodent = response.rodent,
            dog = response.dog,
            other = response.other,
            companyId = response.companyId
        )
    }
}
