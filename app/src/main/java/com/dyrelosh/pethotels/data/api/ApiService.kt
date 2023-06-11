package com.dyrelosh.pethotels.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit: ApiPetHotels = Retrofit.Builder()
        .baseUrl("http://185.139.69.220/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiPetHotels::class.java)
}

//
//
//    val hotels = mutableListOf<HotelRegisterModel>(
//        HotelRegisterModel("123456789101112", "UUUUU", "yfcnzvfcz@mail.ru", "123456789101112"),
//        HotelRegisterModel("111111111111", "qazwsx1", "qwerty@mail.ru", "qaz123!"),
//
//    ) //изменяемый массив
//
//    fun loginCompany(hotelLoginModel: HotelLoginModel): String? {
//        val response =
//            hotels.firstOrNull { it.passwordHotel == hotelLoginModel.passwordHotel &&
//                    it.emailHotel == hotelLoginModel.emailHotel }
//        if(response != null){
//            return token
//        } else
//            return null
//    }
//
//
//    fun registrationHotel(hotelRegisterModel: HotelRegisterModel) { //параметр
//        hotels.add(
//           hotelRegisterModel
//        )
//    }
//
//    private val token = "token"
//
//    fun getToken(): String {
//        return token
//    }
