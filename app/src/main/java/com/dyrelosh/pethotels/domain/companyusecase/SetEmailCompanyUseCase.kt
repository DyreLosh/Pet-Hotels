package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetEmailCompanyUseCase(private val repository: HotelRepository) {
    fun execute(email: String) = repository.setEmail(email)
}