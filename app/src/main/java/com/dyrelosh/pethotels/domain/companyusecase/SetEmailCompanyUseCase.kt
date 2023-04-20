package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetEmailCompanyUseCase(private val hotelRepository: HotelRepository) {
    fun execute(email: String) = hotelRepository.setEmail(email)
}