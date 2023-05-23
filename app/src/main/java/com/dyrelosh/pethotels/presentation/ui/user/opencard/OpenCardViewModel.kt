package com.dyrelosh.pethotels.presentation.ui.user.opencard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.usecase.hotel.GetOneHotelUseCase
import kotlinx.coroutines.launch

class OpenCardViewModel (
    private val getToken: GetTokenHotelUseCase,
    private val getOneHotelUseCase: GetOneHotelUseCase
) : ViewModel() {
    private val token = getToken.execute()

    private var _oneHotel : MutableLiveData<UserHotelModel> = MutableLiveData<UserHotelModel>()
    val oneHotel : LiveData<UserHotelModel> = _oneHotel

    fun getOneHotel(id: String){
        viewModelScope.launch {
            _oneHotel.value = getOneHotelUseCase.execute(token!!, id)
        }
    }

}