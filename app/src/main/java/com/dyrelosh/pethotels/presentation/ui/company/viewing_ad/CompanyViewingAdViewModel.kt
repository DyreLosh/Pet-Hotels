package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.data.api.response.HotelResponse
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyusecase.*
import kotlinx.coroutines.launch

class CompanyViewingAdViewModel(
    private val getTokenHotelUseCase: GetTokenHotelUseCase,
    private val getOneAddUseCase: GetOneAddUseCase,
    private val editAdCompanyUseCase: EditAdCompanyUseCase,
    private val deleteAddUseCase: DeleteAddUseCase,
    private val getHotelPhotoUseCase: GetHotelPhotoUseCase,
    private val setHotelPhotoUseCase: SetHotelPhotoUseCase
) : ViewModel() {
    private val token = getTokenHotelUseCase.execute()

    private var _addInfoID: MutableLiveData<HotelResponse> = MutableLiveData<HotelResponse>()
    val addInfoID: LiveData<HotelResponse> = _addInfoID

    fun getAddInfo(id: String) {
        viewModelScope.launch {
            _addInfoID.value = getOneAddUseCase.execute(token!!, id)
        }
    }

    private var _addInfo: MutableLiveData<HotelAddsModel> = MutableLiveData<HotelAddsModel>()
    val addInfo: LiveData<HotelAddsModel> = _addInfo
    fun editAdCompany(hotelAddsModel: HotelAddsModel) {
        viewModelScope.launch {
            _addInfo.value = editAdCompanyUseCase.execute(token!!, hotelAddsModel)
        }
    }

    val deleteAction: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun deleteAdd(id: String) {
        viewModelScope.launch {
            deleteAction.value = deleteAddUseCase.execute(token!!, id)
        }
    }

    private var _userPhotoLoad: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val userPhotoLoad: LiveData<Boolean> = _userPhotoLoad
    fun setHotelPhoto(imageUrl: String?, id: String) {
        viewModelScope.launch {
            _userPhotoLoad.value =
                setHotelPhotoUseCase.execute(SetHotelPhotoUseCase.Params(token!!, imageUrl, id))
        }
    }

    private var _userPhoto: MutableLiveData<Bitmap> = MutableLiveData<Bitmap>()
    val userPhoto: LiveData<Bitmap> = _userPhoto
    fun getHotelPhoto(id: String) {
        viewModelScope.launch {
            _userPhoto.value = getHotelPhotoUseCase.execute(token!!, id)
        }
    }
}
