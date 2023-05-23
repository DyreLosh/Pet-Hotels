package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository){
    suspend fun execute(registerModel: UserRegisterModel): String? {
        return userRepository.userRegister(registerModel)?.token
    }
}