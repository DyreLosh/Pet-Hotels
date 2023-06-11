package com.dyrelosh.pethotels.domain.usecase.auth

import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.models.UserInfoModel

class GetUserInfoUseCase(private val hotelRepository: HotelRepository){
    suspend fun execute(token: String): UserInfoModel? {
        return hotelRepository.getUserInfoFun(token)
    }
}
