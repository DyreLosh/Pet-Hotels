package com.dyrelosh.pethotels.presentation.ui.user.opencard

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.usecase.hotel.GetCompanyForIdUseCase
import com.dyrelosh.pethotels.domain.usecase.hotel.GetHotelPhotoForUserUseCase
import com.dyrelosh.pethotels.domain.usecase.hotel.GetOneHotelUseCase
import kotlinx.coroutines.launch

class OpenCardViewModel (
    private val getToken: GetTokenHotelUseCase,
    private val getOneHotelUseCase: GetOneHotelUseCase,
    private val getHotelPhotoForUserUseCase: GetHotelPhotoForUserUseCase,
    private val getCompanyForIdUseCase: GetCompanyForIdUseCase
) : ViewModel() {
    private val token = getToken.execute()

    private var _oneHotel : MutableLiveData<UserHotelModel> = MutableLiveData<UserHotelModel>()
    val oneHotel : LiveData<UserHotelModel> = _oneHotel

    fun getOneHotel(id: String){
        viewModelScope.launch {
            _oneHotel.value = getOneHotelUseCase.execute(token!!, id)
        }
    }
    private var _userPhoto: MutableLiveData<Bitmap> = MutableLiveData<Bitmap>()
    val userPhoto: LiveData<Bitmap> = _userPhoto
    fun getHotelPhoto(id: String) {
        viewModelScope.launch {
            _userPhoto.value = getHotelPhotoForUserUseCase.execute(token!!, id)
        }
    }
    private var _companyINN: MutableLiveData<String> = MutableLiveData<String>()
    val companyINN: LiveData<String> = _companyINN
    fun getCompanyINN(id: String) {
        viewModelScope.launch {
            _companyINN.value = getCompanyForIdUseCase.execute(id).inn
        }
    }

}