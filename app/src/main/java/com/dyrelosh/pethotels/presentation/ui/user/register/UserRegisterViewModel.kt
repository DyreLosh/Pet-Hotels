package com.dyrelosh.pethotels.presentation.ui.user.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelRegisterModel
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.domain.usecase.auth.RegisterUseCase
import com.dyrelosh.pethotels.domain.usecase.user.SetTokenUserUseCase
import kotlinx.coroutines.launch

class UserRegisterViewModel(
    private val registerUseCase: RegisterUseCase,
    private val setTokenUserUseCase: SetTokenUserUseCase
) : ViewModel() {


    private val _token: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val token: LiveData<Boolean> = _token

    fun registrationHotel(userRegisterModel: UserRegisterModel) {
        viewModelScope.launch {
            _token.value = registerUseCase.execute(userRegisterModel)
            //_token.value?.let { setTokenUserUseCase.execute(it) }
        }
    }
}