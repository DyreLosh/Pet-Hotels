package com.dyrelosh.pethotels.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companymodels.HotelRegisterModel
import com.dyrelosh.pethotels.domain.companyusecase.EditProfileCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetHotelInfoUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class EditProfileCompanyFragmentViewModel(
    private val editProfileCompanyUseCase: EditProfileCompanyUseCase,
    private val getTokenUseCase: GetTokenHotelUseCase
) : ViewModel() {
    private val token = getTokenUseCase.execute()
    private var _hotelInfo : MutableLiveData<HotelInfoModel?> = MutableLiveData<HotelInfoModel?>()
    val hotelInfo : LiveData<HotelInfoModel?> = _hotelInfo

        fun editProfileCompany(hotelInfoModel: HotelInfoModel) {
            viewModelScope.launch {
                _hotelInfo.value = editProfileCompanyUseCase.execute(token!!, hotelInfoModel)
                _hotelInfo.value?.let { editProfileCompanyUseCase.execute(token, hotelInfoModel) }
            }

        }
}

//fun registrationHotel(hotelRegisterModel: HotelRegisterModel) {
//    viewModelScope.launch {
//        _token.value = registerHotelUseCase.execute(hotelRegisterModel)
//        _token.value?.let { setTokenCompanyUseCase.execute(it) }
//    }
//}