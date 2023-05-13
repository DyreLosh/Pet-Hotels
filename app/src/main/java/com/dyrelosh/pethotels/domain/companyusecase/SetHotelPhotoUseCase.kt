package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import okhttp3.MultipartBody

class SetHotelPhotoUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, image: MultipartBody.Part): Int {
        return hotelRepository.setHotelPhoto(token, image)
    }
}