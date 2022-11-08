package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.presentation.login.CompanyLoginViewModel
import com.dyrelosh.pethotels.presentation.register.CompanyRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationDi = module {
    viewModel {
        CompanyRegisterViewModel(
            registerHotelUseCase = get(),
            setTokenCompanyUseCase = get(),
            setEmailCompanyUseCase = get()

        )
    }
    viewModel {
        CompanyLoginViewModel(
            loginHotelUseCase = get(),
            setTokenCompanyUseCase = get(),
            setEmailCompanyUseCase = get()
        )
    }

//    viewModel {
//        RegistrationViewModel(
//            registrationUserUseCase = get(),
//            setTokenUseCase = get(),
//            setEmailUseCase = get(),
//        )
//    }

}