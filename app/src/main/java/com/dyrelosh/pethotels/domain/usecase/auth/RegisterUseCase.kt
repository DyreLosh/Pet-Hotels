package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.domain.repository.UserRepository
import okhttp3.ResponseBody

class RegisterUseCase(private val hotelRepository: HotelRepository){
    suspend fun execute(registerModel: UserRegisterModel): Int {
        return hotelRepository.userRegister(registerModel)
    }
}