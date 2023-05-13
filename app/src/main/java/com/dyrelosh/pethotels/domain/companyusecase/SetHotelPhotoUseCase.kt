package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import okhttp3.MultipartBody

class SetHotelPhotoUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(params: Params): Int {
        return hotelRepository.setHotelPhoto(params.token, params.image, params.id)
    }

    data class Params(
        val token: String,
        val image: MultipartBody.Part,
        val id: String,
    )
}