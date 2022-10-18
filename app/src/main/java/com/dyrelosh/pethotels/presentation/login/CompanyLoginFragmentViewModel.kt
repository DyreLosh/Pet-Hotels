package com.dyrelosh.pethotels.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dyrelosh.pethotels.domain.userusecase.AuthUserUseCase
import com.dyrelosh.pethotels.models.Token

class CompanyLoginFragmentViewModel(private val authUserUseCase: AuthUserUseCase) {

    private var _token : MutableLiveData<String> = MutableLiveData<String>()
    val token : LiveData<String> = _token

    fun auth(param: AuthUserUseCase.Param){
      _token.value = authUserUseCase.execute(param)
    }
}