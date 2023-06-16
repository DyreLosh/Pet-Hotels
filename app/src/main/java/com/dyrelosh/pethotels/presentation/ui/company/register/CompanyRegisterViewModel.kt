package com.dyrelosh.pethotels.presentation.ui.company.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelRegisterModel
import com.dyrelosh.pethotels.domain.companyusecase.RegisterHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetTokenCompanyUseCase
import kotlinx.coroutines.launch

class CompanyRegisterViewModel(
    private val registerHotelUseCase: RegisterHotelUseCase,
) : ViewModel() {

    private val _errorCode: MutableLiveData<Int> = MutableLiveData<Int>()
    val errorCode: LiveData<Int> = _errorCode

    fun registrationHotel(hotelRegisterModel: HotelRegisterModel) {
        viewModelScope.launch {
            _errorCode.value = registerHotelUseCase.execute(hotelRegisterModel)
        }
    }
}