package com.dyrelosh.pethotels.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companymodels.TokenHotelModel
import com.dyrelosh.pethotels.domain.companyusecase.LoginHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetEmailCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetTokenCompanyUseCase
import com.dyrelosh.pethotels.domain.usecase.auth.SetLoginRoleUseCase
import com.dyrelosh.pethotels.domain.usecase.user.SetPasswordUseCase
import kotlinx.coroutines.launch

class CompanyLoginViewModel(
    private val loginHotelUseCase: LoginHotelUseCase,
    private val setTokenCompanyUseCase: SetTokenCompanyUseCase,
    private val setEmailCompanyUseCase: SetEmailCompanyUseCase,
    private val setPasswordUseCase: SetPasswordUseCase,
) : ViewModel() {

    private var _token: MutableLiveData<TokenHotelModel> = MutableLiveData<TokenHotelModel>()
    val token: LiveData<TokenHotelModel> = _token

    fun loginHotel(hotelLoginModel: HotelLoginModel) {
        viewModelScope.launch {
            _token.value = loginHotelUseCase.execute(hotelLoginModel)
            _token.value?.let {
                setTokenCompanyUseCase.execute(it.token)
            }
            setEmailCompanyUseCase.execute(hotelLoginModel.email)
            setPasswordUseCase.execute(hotelLoginModel.password)
        }
    }
}
