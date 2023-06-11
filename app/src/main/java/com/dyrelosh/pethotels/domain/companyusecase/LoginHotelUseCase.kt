package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companymodels.TokenHotelModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class LoginHotelUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(hotelLoginModel: HotelLoginModel): TokenHotelModel? {
        return hotelRepository.loginCompany(hotelLoginModel)

    }
}



//class LoginUserUseCase (private val todoRepository: TodoRepository) {
//    suspend fun execute(userLoginModel: UserLoginModel): String? {
//        return todoRepository.loginUser(userLoginModel)?.token
//    }
//}