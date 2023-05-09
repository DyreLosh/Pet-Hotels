package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import com.dyrelosh.pethotels.domain.companyusecase.EditAdCompanyUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetAddUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetOneAddUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class CompanyViewingAdViewModel (
    private val getTokenHotelUseCase: GetTokenHotelUseCase,
    private val getOneAddUseCase: GetOneAddUseCase,
    private val editAdCompanyUseCase: EditAdCompanyUseCase
    ) : ViewModel() {
    private val token = getTokenHotelUseCase.execute()

    private var _addInfo : MutableLiveData<HotelAddsModel> = MutableLiveData<HotelAddsModel>()
    val addInfo : LiveData<HotelAddsModel> = _addInfo

    fun getAddInfo(id: String){
        viewModelScope.launch {
            _addInfo.value = getOneAddUseCase.execute(token!!, id)
        }
    }
    fun editAdCompany(hotelAddsModel: HotelAddsModel) {
        viewModelScope.launch {
            _addInfo.value = editAdCompanyUseCase.execute(token!!, hotelAddsModel)
            _addInfo.value?.let { editAdCompanyUseCase.execute(token, hotelAddsModel) }
        }
    }
}
