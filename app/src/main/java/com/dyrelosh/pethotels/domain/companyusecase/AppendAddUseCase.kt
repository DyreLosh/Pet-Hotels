package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class AppendAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, hotelAppendModel: HotelAppendAddModel): Boolean {
        return hotelRepository.appendAdd(token, hotelAppendModel)
    }
}