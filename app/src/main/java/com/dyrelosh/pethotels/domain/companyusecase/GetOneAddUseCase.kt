package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetOneAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): HotelAddsModel {
        return hotelRepository.getAddInfo(token, id)
    }
}
