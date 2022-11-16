package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetTokenCompanyUseCase(private val hotelRepository: HotelRepository) {
    fun execute(token: String){
        hotelRepository.setToken(token)
    }
}