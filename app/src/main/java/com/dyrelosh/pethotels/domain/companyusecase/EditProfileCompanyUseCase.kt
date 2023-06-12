package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelEditModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class EditProfileCompanyUseCase (private val hotelRepository: HotelRepository){
    suspend fun execute(token: String,hotelEditModel: HotelEditModel): HotelEditModel? {
        return hotelRepository.editProfileCompany(token, hotelEditModel)
    }
}
