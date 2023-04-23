package com.dyrelosh.pethotels.presentation.ui.company.company_ads

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyusecase.GetAddUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import kotlinx.coroutines.launch

class CompanyAdsViewModel(
    private val getAddUseCase: GetAddUseCase,
    getTokenHotelUseCase: GetTokenHotelUseCase
) : ViewModel(){
    private val token = getTokenHotelUseCase.execute()
    private var _responseAdds: MutableLiveData<List<HotelAddsModel>> =
        MutableLiveData<List<HotelAddsModel>>()
    val responseAdds: LiveData<List<HotelAddsModel>> = _responseAdds

    fun getAdds(){
        viewModelScope.launch {
            _responseAdds.value = getAddUseCase.execute(token!!)
        }
    }
}
