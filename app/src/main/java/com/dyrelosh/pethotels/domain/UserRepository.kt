package com.dyrelosh.pethotels.domain

import com.dyrelosh.pethotels.data.api.ApiService
import com.dyrelosh.pethotels.domain.userusecase.AuthUserUseCase

class UserRepository {

    fun registrationUser(){

    }

    fun authUser(param: AuthUserUseCase.Param): String {
     //TODO ApiService.users.filter { it.email == param.email && it.password == param.password }
    return ApiService.getToken()
    }
}