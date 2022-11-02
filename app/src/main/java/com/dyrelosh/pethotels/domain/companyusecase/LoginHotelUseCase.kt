package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepositoryImpl

class LoginHotelUseCase(private val hotelRepository: HotelRepositoryImpl) {
    fun execute(hotelLoginModel: HotelLoginModel): String? {
        //return hotelRepository.loginCompany(hotelLoginModel)?.
    return null
    }
}



//class LoginUserUseCase (private val todoRepository: TodoRepository) {
//    suspend fun execute(userLoginModel: UserLoginModel): String? {
//        return todoRepository.loginUser(userLoginModel)?.token
//    }
//}