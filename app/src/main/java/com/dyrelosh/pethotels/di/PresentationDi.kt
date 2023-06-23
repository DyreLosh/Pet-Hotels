package com.dyrelosh.pethotels.di

import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.presentation.ui.company.add_ad.AppendAddViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsViewModel
import com.dyrelosh.pethotels.presentation.login.CompanyLoginViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.CompanyProfileFragmentViewModel
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.EditProfileCompanyFragmentViewModel
import com.dyrelosh.pethotels.presentation.ui.company.register.CompanyRegisterViewModel
import com.dyrelosh.pethotels.presentation.ui.company.viewing_ad.CompanyViewingAdViewModel
import com.dyrelosh.pethotels.presentation.ui.user.changepassword.ChangePasswordViewModel
import com.dyrelosh.pethotels.presentation.ui.user.changeprofile.ChangeProfileViewModel
import com.dyrelosh.pethotels.presentation.ui.user.main.MainViewModel
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardViewModel
import com.dyrelosh.pethotels.presentation.ui.user.profile.UserProfileViewModel
import com.dyrelosh.pethotels.presentation.ui.user.register.UserRegisterViewModel
import com.dyrelosh.pethotels.presentation.ui.user.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationDi = module {
    viewModel {
        CompanyRegisterViewModel(
            registerHotelUseCase = get(),
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
            setHotelPhotoUseCase = get(),
            deletePhotoUseCase = get()
        )
    }

    viewModel {
        UserRegisterViewModel(registerUseCase = get())
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
            getHotelPhotoForUserUseCase = get(),
            getCompanyForIdUseCase = get()
        )
    }

    viewModel {
        SearchViewModel(getHotels = get(), getToken = get())
    }

    viewModel {
        UserProfileViewModel(getToken = get(), getUserInfo = get())
    }

    viewModel {
        ChangeProfileViewModel(
            getToken = get(),
            getUserInfo = get(),
            changeUserEmail = get(),
            changeUserNameUseCase = get()
        )
    }
}
