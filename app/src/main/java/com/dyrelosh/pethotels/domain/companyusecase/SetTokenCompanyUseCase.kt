package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetTokenCompanyUseCase(private val hotelRepository: HotelRepository) {
    fun execute(newToken: String){
        hotelRepository.setToken(newToken)
    }
}