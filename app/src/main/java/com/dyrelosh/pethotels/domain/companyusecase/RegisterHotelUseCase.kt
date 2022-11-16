package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelRegisterModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class RegisterHotelUseCase(private  val hotelRepository: HotelRepository){
    suspend fun execute(hotelRegisterModel: HotelRegisterModel): String? {
        return hotelRepository.registrationHotel(hotelRegisterModel)?.toString()
    }
}