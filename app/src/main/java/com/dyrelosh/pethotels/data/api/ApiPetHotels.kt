package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiPetHotels {

    @POST("api/authentication/registrationCompanyy")
    @Headers("Content-Type: application/json")
    suspend fun registration(@Body body: HotelRegisterModel): Response<Unit> //раньше была токен хотел модель

    @POST("api/authentication/login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body body: HotelLoginModel): Response<TokenHotelModel>

    @GET("api/hotels/GetAutorizeCompany")
    suspend fun getUserInfo(
        @Header("Authorization") token: String?
    ): Response<HotelInfoModel>

    @PUT("api/hotels/profile")
    suspend fun editProfileCompany(
        @Header("Authorization") token: String?,
        @Body body: HotelEditModel
    ): Response<HotelEditModel>

    @PUT("api/hotels/advertisements/advertisement/{id}")
    suspend fun editAdCompany(
        @Header("Authorization") token: String?,
        @Body body: HotelAddsModel,
        @Path("id") id: String
    ): Response<HotelAddsModel>

    @GET("api/hotels/advertisements/{id}")
    suspend fun getAddInfo(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<HotelResponse>

    @GET("api/hotels/GetAutorizeAdv")
    suspend fun getAdds(
        @Header("Authorization") token: String?
    ): Response<List<HotelResponse>>

    @POST("api/hotels/advertisements/create-advertisement")
    suspend fun appendAdd(
        @Header("Authorization") token: String?,
        @Body body: HotelAppendAddModel
    ): Response<HotelResponse>

    @DELETE("api/hotels/advertisements/advertisement/{id}")
    suspend fun deleteAdd(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<Unit>

    @GET("api/hotels/advertisements")
    suspend fun getHotels(
        @Header("Authorization") token: String?
    ): Response<List<UserHotelModel>>

    @GET("api/hotels/advertisements/{id}")
    suspend fun getHotelsID(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<UserHotelModel>
    @Multipart
    @POST("api/hotels/advertisements/{idAdvertisement}")
    suspend fun setHotelPhoto(
        @Header("Authorization") token: String?,
        @Path("idAdvertisement") idAdvertisement: String,
        @Part uploadedFile: MultipartBody.Part,
    ): Response<ResponseBody>

    @POST("api/authentication/registrationUser")
    @Headers("Content-Type: application/json")
    suspend fun userRegister(
        @Body body: UserRegisterModel
    ): Response<Unit>

    @POST("api/authentication/ChangePassword")
    suspend fun changeUserPassword(

    ): Response<ChangePasswordModel>

    @PUT("api/authentication/ChangeEmail/{id}")
    suspend fun changeUserEmail(
        @Header("Authorization") token: String?,
        @Path("id") id: String,
        @Query("email") email: String
    ): Response<HotelInfoModel>

    @PUT("api/authentication/ChangeUserName{id}")
    suspend fun changeUserName(
        @Header("Authorization") token: String?,
        @Path("id") id: String,
        @Query("userName") userName: String
    ): Response<HotelInfoModel>

    @GET("api/authentication/CheckAuthorization")
    suspend fun getUserInfoFun(
        @Header("Authorization") token: String?
    ): Response<UserInfoModel>

    @GET("photo/{imageId}")
    suspend fun getHotelPhoto(
        @Header("Authorization") token: String?,
        @Path("imageId") id: String
    ): Response<ResponseBody>
    @POST("api/authentication/ChangePassword")
    suspend fun changePassword(
        @Header("Authorization") token: String?,
        @Body body: ChangePasswordModel
    ): Response<Unit>

}