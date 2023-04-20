package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepositoryImpl
import org.koin.dsl.module

val dataDi = module {
    single<HotelRepository> {
        HotelRepositoryImpl(context = get())
    }
}