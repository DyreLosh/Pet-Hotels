package com.dyrelosh.pethotels.presentation.ui.company.company_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companymodels.HotelEditModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyusecase.ChangePasswordUseCase
import com.dyrelosh.pethotels.domain.companyusecase.EditProfileCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetHotelInfoUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class EditProfileCompanyFragmentViewModel(

    private val getHotelInfoUseCase: GetHotelInfoUseCase,
    private val editProfileCompanyUseCase: EditProfileCompanyUseCase,
    private val getTokenUseCase: GetTokenHotelUseCase,
    private val changePasswordUseCase: ChangePasswordUseCase
) : ViewModel() {
    private val token = getTokenUseCase.execute()
    private var _hotelInfo : MutableLiveData<HotelInfoModel?> = MutableLiveData<HotelInfoModel?>()
    val hotelInfo : LiveData<HotelInfoModel?> = _hotelInfo

    fun getUserInfo() {
        viewModelScope.launch {
            _hotelInfo.value = getHotelInfoUseCase.execute(token!!)
        }
    }

    private var _hotelEdit : MutableLiveData<HotelEditModel?> = MutableLiveData<HotelEditModel?>()
    val hotelEdit : LiveData<HotelEditModel?> = _hotelEdit
    fun editProfileCompany(hotelEditModel: HotelEditModel) {
        viewModelScope.launch {
            _hotelEdit.value = editProfileCompanyUseCase.execute(token!!, hotelEditModel)
            _hotelEdit.value?.let { editProfileCompanyUseCase.execute(token, hotelEditModel) }
        }
    }


    val passChan : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun changePassword(changePasswordModel: ChangePasswordModel) {
        viewModelScope.launch {
            passChan.value = changePasswordUseCase.execute(token!!, changePasswordModel)
        }
    }

}