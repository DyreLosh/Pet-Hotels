package com.dyrelosh.pethotels.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companyusecase.LoginHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetEmailCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetTokenCompanyUseCase
import kotlinx.coroutines.launch

class CompanyLoginViewModel(
    private val loginHotelUseCase: LoginHotelUseCase,
    private val setTokenCompanyUseCase: SetTokenCompanyUseCase,
    private val setEmailCompanyUseCase: SetEmailCompanyUseCase
    ) : ViewModel() {

    private var _token: MutableLiveData<String?> = MutableLiveData<String?>()
    val token: LiveData<String?> = _token

    fun loginHotel(hotelLoginModel: HotelLoginModel) {
        viewModelScope.launch {
            _token.value = loginHotelUseCase.execute(hotelLoginModel)
            _token.value?.let { setTokenCompanyUseCase.execute(it) }
        }
    }

        fun setEmail(emailHotel: String) {
            setEmailCompanyUseCase.execute(emailHotel)
        }
    }
