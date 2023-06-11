package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.domain.companymodels.*
import com.dyrelosh.pethotels.domain.models.TokenModel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiPetHotels {

    @POST("api/pethotel/auth/registration")
    @Headers("Content-Type: application/json")
    suspend fun registrationUser(@Body body: HotelRegisterModel): Response<TokenHotelModel>

    @POST("api/pethotel/auth/registration")
    @Headers("Content-Type: application/json")
    suspend fun registration(@Body body: HotelRegisterModel): Response<TokenHotelModel>

    @POST("api/authentication/login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body body: HotelLoginModel): Response<TokenHotelModel>

    @GET("api/pethotel/hotelinfo")
    suspend fun getUserInfo(
        @Header("Authorization") token: String?
    ): Response<HotelInfoModel>

    @PUT("api/pethotel/hotelinfo")
    suspend fun editProfileCompany(
        @Header("Authorization") token: String?,
        @Body body: HotelInfoModel
    ): Response<HotelInfoModel>

    @GET("api/pethotel/advertisement/{id}")
    suspend fun getAddInfo(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<HotelAddsModel>

    @POST("api/authentication/ChangePassword")
    suspend fun changePassword(
        @Header("Authorization") token: String?,
        @Body body: ChangePasswordModel
    ): Response<Unit>

    @GET("api/pethotel/advertisement")
    suspend fun getAdds(
        @Header("Authorization") token: String?
    ): Response<List<HotelAddsModel>>

    @POST("api/pethotel/advertisement")
    suspend fun appendAdd(
        @Header("Authorization") token: String?,
        @Body body: HotelAppendAddModel
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

    ): Response<HotelInfoModel>

    @PUT("api/authentication/ChangeUserName{id}")
    suspend fun changeUserName(

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

}