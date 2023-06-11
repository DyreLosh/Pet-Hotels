package com.dyrelosh.pethotels.domain.usecase.user

import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class ChangeUserPasswordUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, changePasswordModel: ChangePasswordModel): Boolean {
        return hotelRepository.changeUserPassword(token, changePasswordModel)
    }
}