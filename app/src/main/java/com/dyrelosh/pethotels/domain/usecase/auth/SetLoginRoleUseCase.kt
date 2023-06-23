package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetLoginRoleUseCase(private val hotelRepository: HotelRepository) {
    fun execute(role: String) = hotelRepository.setLoginRole(role)
}