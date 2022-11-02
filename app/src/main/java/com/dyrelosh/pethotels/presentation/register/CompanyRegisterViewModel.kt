package com.dyrelosh.pethotels.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelCreateModel
import com.dyrelosh.pethotels.domain.companyusecase.RegisterHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetEmailCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetTokenCompanyUseCase
import kotlinx.coroutines.launch

class CompanyRegisterViewModel(
    private val registerHotelUseCase: RegisterHotelUseCase,
    private val setTokenCompanyUseCase: SetTokenCompanyUseCase,
    private val setEmailCompanyUseCase: SetEmailCompanyUseCase
) : ViewModel() {

    private val _token: MutableLiveData<String?> = MutableLiveData<String?>()
    val token: LiveData<String?> = _token

    fun registrationUser(hotelCreateModel: HotelCreateModel) {
        viewModelScope.launch {
            _token.value = registerHotelUseCase.execute(hotelCreateModel)
            _token.value?.let { setTokenCompanyUseCase.execute(it) }
        }
    }

    fun setEmail(email: String) {
        setEmailCompanyUseCase.execute(email)
    }


}