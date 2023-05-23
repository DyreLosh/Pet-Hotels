package com.dyrelosh.pethotels.domain.usecase.hotel

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class GetOneHotelUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): UserHotelModel {
        return hotelRepository.getOneHotel(token, id)
    }
}
