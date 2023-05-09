package com.dyrelosh.pethotels.presentation.ui.company.edit_ad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyusecase.*
import kotlinx.coroutines.launch

class EditAdViewModel(
    private val editAdCompanyUseCase: EditAdCompanyUseCase,
    private val getOneAddUseCase: GetOneAddUseCase,
    private val getTokenUseCase: GetTokenHotelUseCase
) : ViewModel() {
    private val token = getTokenUseCase.execute()

    private var _adInfo : MutableLiveData<HotelAddsModel> = MutableLiveData<HotelAddsModel>()
    val adInfo : LiveData<HotelAddsModel> = _adInfo

    fun getAddInfo(id: String){
        viewModelScope.launch {
            _adInfo.value = getOneAddUseCase.execute(token!!, id)
        }
    }

    fun editAdCompany(hotelAddsModel: HotelAddsModel) {
        viewModelScope.launch {
            _adInfo.value = editAdCompanyUseCase.execute(token!!, hotelAddsModel)
            _adInfo.value?.let { editAdCompanyUseCase.execute(token, hotelAddsModel) }
        }
    }
}
