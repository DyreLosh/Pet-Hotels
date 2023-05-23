package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.repository.UserRepository

class GetTokenUseCase(private val userRepository: UserRepository) {

    fun execute() = userRepository.getToken()
}