package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.presentation.add_ad.AppendAddViewModel
import com.dyrelosh.pethotels.presentation.company_ads.CompanyAdsViewModel
import com.dyrelosh.pethotels.presentation.login.CompanyLoginViewModel
import com.dyrelosh.pethotels.presentation.profile.CompanyProfileFragmentViewModel
import com.dyrelosh.pethotels.presentation.profile.EditProfileCompanyFragmentViewModel
import com.dyrelosh.pethotels.presentation.register.CompanyRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationDi = module {
    viewModel {
        CompanyRegisterViewModel(
            registerHotelUseCase = get(),
            setTokenCompanyUseCase = get(),
            //setEmailCompanyUseCase = get()

        )
    }
    viewModel {
        CompanyLoginViewModel(
            loginHotelUseCase = get(),
            setTokenCompanyUseCase = get(),
            setEmailCompanyUseCase = get()
        )
    }
    viewModel {
        CompanyProfileFragmentViewModel(
            getHotelInfoUseCase = get(),
            getTokenUseCase = get()
        )
    }
    viewModel{
        EditProfileCompanyFragmentViewModel(
            editProfileCompanyUseCase = get(),
            getTokenUseCase= get()
        )
    }
    viewModel{
        AppendAddViewModel(
            appendAddUseCase = get(),
            getTokenHotelUseCase = get()
        )
    }
    viewModel{
        CompanyAdsViewModel(
            getAddUseCase = get(),
            getTokenHotelUseCase = get()
        )
    }


}