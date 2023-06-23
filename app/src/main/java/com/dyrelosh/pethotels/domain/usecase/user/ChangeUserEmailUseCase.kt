package com.dyrelosh.pethotels.domain.usecase.user

import com.dyrelosh.pethotels.domain.companymodels.ChangeEmailModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class ChangeUserEmailUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String, email: String): Boolean {
        return hotelRepository.changeUserEmail(token, id, email)
    }
}