package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyusecase.*
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
    factory {
        LoginHotelUseCase(get())
    }
    factory {
        GetHotelInfoUseCase(get())
    }
    factory {
        GetEmailCompanyUseCase(get())
    }
    factory {
        GetTokenHotelUseCase(get())
    }
    factory {
        EditProfileCompanyUseCase(get())
    }
    factory {
        AppendAddUseCase(get())
    }
    factory {
        GetAddUseCase(get())
    }
    factory {
        GetOneAddUseCase(get())
    }
    factory {
        EditAdCompanyUseCase(get())
    }
    factory {
        DeleteAddUseCase(get())
    }
    factory {
        GetHotelPhotoUseCase(get())
    }
    factory {
        SetHotelPhotoUseCase(get())
    }
    factory {
        ClearPreferenceUseCase(get())
    }
    factory {
        ChangePasswordUseCase(get())
    }
}