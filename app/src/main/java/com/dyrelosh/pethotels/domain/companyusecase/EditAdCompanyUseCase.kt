package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class EditAdCompanyUseCase (private val hotelRepository: HotelRepository){
    suspend fun execute(token: String, hotelAddsModel: HotelAddsModel, id: String): HotelAddsModel? {
        return hotelRepository.editAdCompany(token, hotelAddsModel, id)
    }
}
