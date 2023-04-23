package com.dyrelosh.pethotels.presentation.ui.company.add_ad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class AppendAddViewModel(
    private val appendAddUseCase: AppendAddUseCase,
    getTokenHotelUseCase: GetTokenHotelUseCase
) : ViewModel() {
    private val token = getTokenHotelUseCase.execute()
    private val _appendAddAction: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>()
    val appendAddAction: LiveData<Boolean> = _appendAddAction

    fun appendAdd(hotelAppendAddModel: HotelAppendAddModel){
        viewModelScope.launch {
            _appendAddAction.value = appendAddUseCase.execute(token!!, hotelAppendAddModel)
        }
    }
}

