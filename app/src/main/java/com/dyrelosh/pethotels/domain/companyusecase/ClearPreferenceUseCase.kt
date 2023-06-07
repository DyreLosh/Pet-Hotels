package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository


class ClearPreferenceUseCase(private val hotelRepository: HotelRepository) {
        fun execute() = hotelRepository.clearPreference()
}
