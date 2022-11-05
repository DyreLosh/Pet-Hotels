package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.domain.companymodels.HotelCreateModel
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel


object ApiService {


    val hotels = mutableListOf<HotelCreateModel>(
        HotelCreateModel("123456789101112", "UUUUU", "yfcnzvfcz@mail.ru", "123456789101112"),
        HotelCreateModel("", "", "", ""),

    ) //изменяемый массив

    fun loginCompany(hotelLoginModel: HotelLoginModel): String? {
        val response =
            hotels.firstOrNull { it.passwordHotel == hotelLoginModel.passwordHotel &&
                    it.emailHotel == hotelLoginModel.emailHotel }
        if(response != null){
            return token
        }
        return null
    }


    fun registrationHotel(hotelCreateModel: HotelCreateModel) { //параметр
        hotels.add(
           hotelCreateModel
        )
    }

    private val token = "token"

    fun getToken(): String {
        return token
    }


}