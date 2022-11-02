package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelCreateModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class RegisterHotelUseCase(private  val hotelRepository: HotelRepository){
    suspend fun execute(hotelCreateModel: HotelCreateModel): String? {
        return hotelRepository.registrationHotel(hotelCreateModel)?.toString()
    }
}