package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetEmailCompanyUseCase(private val hotelRepository: HotelRepository) {
    fun execute(): String? {
        return hotelRepository.getEmail()
    }
}