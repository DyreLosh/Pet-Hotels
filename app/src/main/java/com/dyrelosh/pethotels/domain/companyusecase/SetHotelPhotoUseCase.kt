package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetHotelPhotoUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(params: Params): Boolean {
        return hotelRepository.setHotelPhoto(params.token, params.imageUrl, params.idAdvertisement)
    }

    data class Params(
        val token: String,
        val imageUrl: String?,
        val idAdvertisement: String,
    )
}