package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.repository.UserRepository

class GetTokenUseCase(private val hotelRepository: HotelRepository) {

    fun execute() = hotelRepository.getToken()
}