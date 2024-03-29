package com.dyrelosh.pethotels.domain.usecase.user

import com.dyrelosh.pethotels.domain.companymodels.ChangeUserNameModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class ChangeUserNameUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String, id: String, userName: String): Boolean {
        return hotelRepository.changeUserName(token, id, userName)
    }
}