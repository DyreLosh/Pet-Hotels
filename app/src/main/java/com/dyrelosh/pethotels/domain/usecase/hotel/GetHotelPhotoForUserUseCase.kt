package com.dyrelosh.pethotels.domain.usecase.hotel

import android.graphics.Bitmap
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetHotelPhotoForUserUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String): Bitmap? {
        return hotelRepository.getHotelPhotoUser(token, id)
    }
}