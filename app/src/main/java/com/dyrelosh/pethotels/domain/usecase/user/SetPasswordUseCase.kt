package com.dyrelosh.pethotels.domain.usecase.user

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetPasswordUseCase(private val hotelRepository: HotelRepository) {
    fun execute(password: String) = hotelRepository.setPassword(password)
}