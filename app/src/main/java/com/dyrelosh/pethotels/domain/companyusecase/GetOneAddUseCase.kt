package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetOneAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): HotelResponse {
        return hotelRepository.getAddInfo(token, id)
    }
}
