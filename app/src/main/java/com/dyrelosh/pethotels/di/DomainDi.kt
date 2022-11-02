package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyusecase.RegisterHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetEmailCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetTokenCompanyUseCase
import org.koin.dsl.module

val domainDi = module {
    factory {
        RegisterHotelUseCase(get())
    }
    factory {
        SetTokenCompanyUseCase(get())
    }
    factory {
        SetEmailCompanyUseCase(get())
    }
}