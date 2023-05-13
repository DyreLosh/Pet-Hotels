package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class AppendAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, hotelAppendModel: HotelAppendAddModel): Hotel {
        return hotelRepository.appendAdd(token, hotelAppendModel)
    }
}