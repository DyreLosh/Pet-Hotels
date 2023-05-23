package com.dyrelosh.pethotels.domain.usecase.hotel

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class GetHotelsUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String): List<UserHotelModel>? {
        return hotelRepository.getHotels(token)
    }
}