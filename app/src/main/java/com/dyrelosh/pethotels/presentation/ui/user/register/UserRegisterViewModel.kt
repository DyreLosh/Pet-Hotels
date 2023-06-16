package com.dyrelosh.pethotels.presentation.ui.user.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.domain.usecase.auth.RegisterUseCase
import com.dyrelosh.pethotels.domain.usecase.user.SetTokenUserUseCase
import kotlinx.coroutines.launch

class UserRegisterViewModel(
    private val registerUseCase: RegisterUseCase,
) : ViewModel() {
    private val _errorCode: MutableLiveData<Int> = MutableLiveData<Int>()
    val errorCode: LiveData<Int> = _errorCode

    fun registrationHotel(userRegisterModel: UserRegisterModel) {
        viewModelScope.launch {
            _errorCode.value = registerUseCase.execute(userRegisterModel)
        }
    }
}