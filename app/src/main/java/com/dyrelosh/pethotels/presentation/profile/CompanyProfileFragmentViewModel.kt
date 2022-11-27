package com.dyrelosh.pethotels.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyusecase.GetHotelInfoUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class CompanyProfileFragmentViewModel(
    private val getHotelInfoUseCase: GetHotelInfoUseCase,
    private val getTokenUseCase: GetTokenHotelUseCase
) : ViewModel() {
    private val token = getTokenUseCase.execute()

    private var _hotelInfo : MutableLiveData<HotelInfoModel?> = MutableLiveData<HotelInfoModel?>()
    val hotelInfo : LiveData<HotelInfoModel?> = _hotelInfo
    fun getUserInfo() {
        viewModelScope.launch {
            _hotelInfo.value = getHotelInfoUseCase.execute(token!!)
        }
    }
}