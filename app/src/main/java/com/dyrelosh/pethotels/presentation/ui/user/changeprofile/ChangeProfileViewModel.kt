package com.dyrelosh.pethotels.presentation.ui.user.changeprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.ChangeEmailModel
import com.dyrelosh.pethotels.domain.companymodels.ChangeUserNameModel
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.models.UserInfoModel
import com.dyrelosh.pethotels.domain.usecase.auth.GetUserInfoUseCase
import com.dyrelosh.pethotels.domain.usecase.user.ChangeUserEmailUseCase
import com.dyrelosh.pethotels.domain.usecase.user.ChangeUserNameUseCase
import kotlinx.coroutines.launch

class ChangeProfileViewModel(
    private val getToken: GetTokenHotelUseCase,
    private val getUserInfo: GetUserInfoUseCase,
    private val changeUserEmail: ChangeUserEmailUseCase,
    private val changeUserNameUseCase: ChangeUserNameUseCase
) : ViewModel() {
    private val token = getToken.execute()
    private var _response: MutableLiveData<UserInfoModel> =
        MutableLiveData<UserInfoModel>()
    val response: LiveData<UserInfoModel> = _response
    val email: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val userName: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun getUserInfo() {
        viewModelScope.launch {
            _response.value = getUserInfo.execute(token!!)
        }
    }

    fun changeUserEmail(id: String, emailUser: String) {
        viewModelScope.launch {
            email.value = changeUserEmail.execute(token!!, id, emailUser)
        }
    }

    fun changeUserName(id: String, userLogin: String) {
        viewModelScope.launch {
            userName.value = changeUserNameUseCase.execute(token!!, id, userLogin)
        }
    }
}