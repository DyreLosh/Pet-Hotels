package com.dyrelosh.pethotels.domain.userusecase

import com.dyrelosh.pethotels.domain.UserRepository

class AuthUserUseCase(private val userRepository: UserRepository) {
    fun execute(param: Param): String {
        return userRepository.authUser(param)
    }

  data  class Param(
        val email: String,
        val password: String
    )
}