package com.dyrelosh.pethotels.presentation.ui.user.changepassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companyusecase.ChangePasswordUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.usecase.auth.GetTokenUseCase
import com.dyrelosh.pethotels.domain.usecase.user.ChangeUserPasswordUseCase
import kotlinx.coroutines.launch

class ChangePasswordViewModel(
    private val getTokenUseCase: GetTokenHotelUseCase,
    private val changeUserPasswordUseCase: ChangeUserPasswordUseCase
) : ViewModel() {
    private val token = getTokenUseCase.execute()

    val pass: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun changePassword(changePasswordModel: ChangePasswordModel) {
        viewModelScope.launch {
            pass.value = changeUserPasswordUseCase.execute(token!!, changePasswordModel)
        }
    }
}