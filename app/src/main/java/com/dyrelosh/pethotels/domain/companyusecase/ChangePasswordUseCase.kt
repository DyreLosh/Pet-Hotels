package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class ChangePasswordUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, changePasswordModel: ChangePasswordModel): Boolean {
        return hotelRepository.changePassword(token, changePasswordModel)
    }
}