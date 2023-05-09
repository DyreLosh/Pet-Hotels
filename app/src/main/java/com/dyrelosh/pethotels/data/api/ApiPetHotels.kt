package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.domain.companymodels.*
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
    ): Response<HotelAddsModel>

    @PUT("api/pethotel/advertisement")
    suspend fun editAdCompany(
        @Header("Authorization") token: String?,
        @Body body: HotelAddsModel
    ): Response<HotelAddsModel>

    @GET("api/pethotel/advertisement")
    suspend fun getAdds(
        @Header("Authorization") token: String?
    ): Response<List<HotelAddsModel>>

    @POST("api/pethotel/advertisement")
    suspend fun appendAdd(
        @Header("Authorization") token: String?,
        @Body body: HotelAppendAddModel
    ): Response<Unit>

//    @DELETE("api/todos/{id}")
//    suspend fun deleteTodos(
//        @Header("Authorization") token: String?,
//        @Path("id") id: String
//    ): Response<Unit>
//
//
//


//    @Multipart
//    @POST("api/user/photo")
//    suspend fun setUserPhoto(
//        @Header("Authorization") token: String?,
//        @Part uploadedFile: MultipartBody.Part
//    ): Response<Unit>
//
//    @GET("api/user/photo/{fileId}")
//    suspend fun getUserPhoto(
//        @Header("Authorization") token: String?,
//        @Path("fileId") id: String
//    ): Response<ResponseBody>

}