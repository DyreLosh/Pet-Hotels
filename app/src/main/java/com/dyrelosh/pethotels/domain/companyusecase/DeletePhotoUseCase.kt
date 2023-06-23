package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class DeletePhotoUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, imageId: String): Boolean {
        return hotelRepository.deletePhoto(token, imageId)
    }
}
