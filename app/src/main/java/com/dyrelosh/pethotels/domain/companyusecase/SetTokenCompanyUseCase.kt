package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class SetTokenCompanyUseCase(private val repository: HotelRepository) {
    fun execute(token: String){
        repository.setToken(token)
    }
}