package com.dyrelosh.pethotels.presentation.ui.user.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.domain.usecase.hotel.GetHotelsUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val getHotels: GetHotelsUseCase, private val getToken: GetTokenHotelUseCase
) : ViewModel(){
    private val token = getToken.execute()
    private var _response: MutableLiveData<List<UserHotelModel>> =
        MutableLiveData<List<UserHotelModel>>()
    val response: LiveData<List<UserHotelModel>> = _response

    fun getHotels(){
        viewModelScope.launch {

            _response.value = getHotels.execute(token!!)
        }
    }
}