package com.dyrelosh.pethotels.domain.usecase.hotel

import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetCompanyForIdUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(id: String): HotelInfoModel {
        return hotelRepository.getCompanyForId(id)
    }
}