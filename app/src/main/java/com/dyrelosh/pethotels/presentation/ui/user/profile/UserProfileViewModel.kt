package com.dyrelosh.pethotels.presentation.ui.user.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.usecase.auth.GetTokenUseCase
import com.dyrelosh.pethotels.domain.usecase.auth.GetUserInfoUseCase
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val getToken: GetTokenHotelUseCase,
    private val getUserInfo: GetUserInfoUseCase
) : ViewModel() {
    private val token = getToken.execute()
    private var _response: MutableLiveData<UserInfoModel> =
        MutableLiveData<UserInfoModel>()
    val response: LiveData<UserInfoModel> = _response

    fun getUserInfo() {
        viewModelScope.launch {
            _response.value = getUserInfo.execute(token!!)
        }
    }
}