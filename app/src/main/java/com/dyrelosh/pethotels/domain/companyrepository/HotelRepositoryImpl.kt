package com.dyrelosh.pethotels.domain.companyrepository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.domain.companymodels.*
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
        return ApiService.retrofit.editProfileCompany("Bearer $token",hotelEditModel).body()
    }

    override suspend fun editAdCompany(token: String, addsModel: HotelAddsModel, id: String): HotelAddsModel? {
        return ApiService.retrofit.editAdCompany("Bearer $token", addsModel, id).body()
    }

    override suspend fun setHotelPhoto(token: String, imageUrl: String?, idAdvertisement: String): Boolean {
        return ApiService.retrofit.setHotelPhoto(
            "Bearer $token", idAdvertisement, File(imageUrl).toMultipartPart(AVATAR_PART_NAME)
        ).isSuccessful
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
            ?.map { hotelResponseToModel(it,
                it.photos.firstOrNull()?.let { it1 -> getHotelPhoto(token, it1) }) }
    }

    override suspend fun appendAdd(
        token: String,
        hotelAppendAddModel: HotelAppendAddModel
    ):HotelResponse {
        return ApiService.retrofit.appendAdd("Bearer $token", hotelAppendAddModel).body()!!
    }

    override suspend fun changePassword(token: String, changePasswordModel: ChangePasswordModel): Boolean {
        return ApiService.retrofit.changePassword("Bearer $token", changePasswordModel).isSuccessful
    }


    override suspend fun deleteAdd(token: String, id: String): Boolean {
        return ApiService.retrofit.deleteAdd("Bearer $token", id).isSuccessful
    }
    override fun clearPreference(): Boolean {
        preferenceStorage.clearPreference()
        return true
    }

}

private fun hotelResponseToModel(response: HotelResponse, hotelPhoto: Bitmap?): Hotel {
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
