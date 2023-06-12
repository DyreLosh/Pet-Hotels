package com.dyrelosh.pethotels.domain.companyusecase

import android.graphics.Bitmap
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetHotelPhotoUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): Bitmap? {
        return hotelRepository.getHotelPhoto(token, id)
    }
}