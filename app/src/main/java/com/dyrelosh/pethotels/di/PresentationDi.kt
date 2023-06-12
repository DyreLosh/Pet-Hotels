package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.presentation.ui.company.add_ad.AppendAddViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsViewModel
import com.dyrelosh.pethotels.presentation.login.CompanyLoginViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.CompanyProfileFragmentViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.EditProfileCompanyFragmentViewModel
import com.dyrelosh.pethotels.presentation.ui.company.register.CompanyRegisterViewModel
import com.dyrelosh.pethotels.presentation.ui.company.viewing_ad.CompanyViewingAdViewModel
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
            setEmailCompanyUseCase = get(),
            setPasswordUseCase = get()
        )
    }
    viewModel {
        CompanyProfileFragmentViewModel(
            getHotelInfoUseCase = get(),
            getTokenUseCase = get(),
            clearPreferenceUseCase = get()
        )
    }
    viewModel {
        EditProfileCompanyFragmentViewModel(
            editProfileCompanyUseCase = get(),
            getTokenUseCase = get(),
            getHotelInfoUseCase = get(),
            changePasswordUseCase = get()
        )
    }
    viewModel {
        AppendAddViewModel(
            appendAddUseCase = get(),
            getTokenHotelUseCase = get(),
            getHotelPhotoUseCase = get(),
            setHotelPhotoUseCase = get()
        )
    }
    viewModel {
        CompanyAdsViewModel(
            getAddUseCase = get(),
            getTokenHotelUseCase = get()
        )
    }
    viewModel {
        CompanyViewingAdViewModel(
            getTokenHotelUseCase = get(),
            editAdCompanyUseCase = get(),
            getOneAddUseCase = get(),
            deleteAddUseCase = get(),
            getHotelPhotoUseCase = get(),
            setHotelPhotoUseCase = get()
        )
    }

    viewModel {
        UserRegisterViewModel(registerUseCase = get(), setTokenUserUseCase = get())
    }

    viewModel {
        ChangePasswordViewModel(getTokenUseCase = get(), changeUserPasswordUseCase = get())
    }

    viewModel {
        MainViewModel(getHotels = get(), getToken = get())
    }

    viewModel {
        OpenCardViewModel(
            getToken = get(),
            getOneHotelUseCase = get(),
            getHotelPhotoForUserUseCase = get()
        )
    }

    viewModel {
        SearchViewModel(getHotels = get(), getToken = get())
    }

    viewModel {
        UserProfileViewModel(getToken = get(), getUserInfo = get())
    }
}
