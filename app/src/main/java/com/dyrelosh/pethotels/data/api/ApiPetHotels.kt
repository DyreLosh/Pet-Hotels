package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiPetHotels {

    @POST("api/pethotel/auth/registration")
    @Headers("Content-Type: application/json")
    suspend fun registration(@Body body: HotelRegisterModel): Response<TokenHotelModel>

    @POST("api/pethotel/auth/login")
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
    ): Response<HotelResponse>

    @PUT("api/pethotel/advertisement")
    suspend fun editAdCompany(
        @Header("Authorization") token: String?,
        @Body body: HotelAddsModel
    ): Response<HotelAddsModel>

    @GET("api/pethotel/advertisement")
    suspend fun getAdds(
        @Header("Authorization") token: String?
    ): Response<List<HotelResponse>>

    @POST("api/pethotel/advertisement")
    suspend fun appendAdd(
        @Header("Authorization") token: String?,
        @Body body: HotelAppendAddModel
    ): Response<HotelResponse>

    @DELETE("api/pethotel/advertisement/{id}")
    suspend fun deleteAdd(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<Unit>

    @Multipart
    @POST("api/pethotel/advertisement/{advertisementId}/photo")
    suspend fun setHotelPhoto(
        @Header("Authorization") token: String?,
        @Path("advertisementId") advertisementId: String,
        @Part file: MultipartBody.Part,
    ): Response<Unit>

    @GET("photo/{fileId}")
    suspend fun getHotelPhoto(
        @Header("Authorization") token: String?,
        @Path("fileId") id: String
    ): Response<ResponseBody>

}