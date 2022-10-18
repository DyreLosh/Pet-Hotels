package com.dyrelosh.pethotels.data.api

import com.dyrelosh.pethotels.domain.userusecase.AuthUserUseCase
import com.dyrelosh.pethotels.models.UserModel

object ApiService {


    val users = mutableListOf<UserModel>(
        UserModel("1", "", "", ""),
        UserModel("2", "", "", ""),
        UserModel("3", "", "", ""),
        UserModel("4", "", "", "")
    ) //изменяемый массив

    fun authUser(param: AuthUserUseCase.Param): String? {
        val response =
            users.firstOrNull { it.password == param.password && it.email == param.password }
        if(response != null){
            return token
        }
        return null
    }
    fun registrationUser(){ //параметр
        users.add(
            UserModel(
            "",
            "", // из параметра
                "",// из параметра
                ""// из параметра
        ))
    }



    private val token = "token"

    fun getToken(): String {
        return token
    }


}