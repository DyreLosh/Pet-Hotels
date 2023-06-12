package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class DeleteAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): Boolean {
        return hotelRepository.deleteAdd(token, id)
    }
}
