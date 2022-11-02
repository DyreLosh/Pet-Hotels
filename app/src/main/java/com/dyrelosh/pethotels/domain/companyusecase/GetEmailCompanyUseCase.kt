package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetEmailCompanyUseCase(private val repository: HotelRepository) {
    fun execute(): String? {
        return repository.getEmail()
    }
}