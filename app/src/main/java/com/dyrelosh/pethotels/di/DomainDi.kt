package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyusecase.*
import com.dyrelosh.pethotels.domain.usecase.auth.GetUserInfoUseCase
import com.dyrelosh.pethotels.domain.usecase.auth.RegisterUseCase
import com.dyrelosh.pethotels.domain.usecase.hotel.GetHotelPhotoForUserUseCase
import com.dyrelosh.pethotels.domain.usecase.hotel.GetHotelsUseCase
import com.dyrelosh.pethotels.domain.usecase.hotel.GetOneHotelUseCase
import com.dyrelosh.pethotels.domain.usecase.user.ChangeUserPasswordUseCase
import com.dyrelosh.pethotels.domain.usecase.user.SetPasswordUseCase
import com.dyrelosh.pethotels.domain.usecase.user.SetTokenUserUseCase
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
        RegisterUseCase(get())
    }
    factory { SetTokenUserUseCase(get()) }

    factory {
        ChangeUserPasswordUseCase(get())
    }
    factory {
        GetHotelsUseCase(get())
    }
    factory {
        GetOneHotelUseCase(get())
    }
    factory {
        GetUserInfoUseCase(get())
    }

    factory {
        SetPasswordUseCase(get())
    }
    factory {
        GetHotelPhotoForUserUseCase(get())
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