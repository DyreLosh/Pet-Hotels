package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.domain.repository.UserRepository

class RegisterUseCase(private val hotelRepository: HotelRepository){
    suspend fun execute(registerModel: UserRegisterModel): Boolean {
        return hotelRepository.userRegister(registerModel)
    }
}