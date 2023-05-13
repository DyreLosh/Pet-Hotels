package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String): List<Hotel>? {
        return hotelRepository.getAdds(token)
    }
}