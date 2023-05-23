package com.dyrelosh.pethotels.domain.usecase.user

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.repository.UserRepository

class SetTokenUserUseCase(private val hotelRepository: HotelRepository) {
    fun execute(newToken: String){
        hotelRepository.setToken(newToken)
    }
}