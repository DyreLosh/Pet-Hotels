package com.dyrelosh.pethotels.presentation.ui.company.add_ad

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.domain.companyusecase.AppendAddUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetHotelPhotoUseCase
import com.dyrelosh.pethotels.domain.companyusecase.GetTokenHotelUseCase
import com.dyrelosh.pethotels.domain.companyusecase.SetHotelPhotoUseCase
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class AppendAddViewModel(
    private val appendAddUseCase: AppendAddUseCase,
    private val getTokenHotelUseCase: GetTokenHotelUseCase,
    private val getHotelPhotoUseCase: GetHotelPhotoUseCase,
    private val setHotelPhotoUseCase: SetHotelPhotoUseCase
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

    private var _userPhotoLoad : MutableLiveData<Int> = MutableLiveData<Int>()
    val userPhotoLoad : LiveData<Int> = _userPhotoLoad
    fun setHotelPhoto(image: MultipartBody.Part){
        viewModelScope.launch {
            _userPhotoLoad.value = setHotelPhotoUseCase .execute(token!!, image)
        }
    }

    private var _userPhoto :MutableLiveData<Bitmap> = MutableLiveData<Bitmap>()
    val userPhoto :LiveData<Bitmap> = _userPhoto
    fun getHotelPhoto(id: String){
        viewModelScope.launch {
            _userPhoto.value = getHotelPhotoUseCase.execute(token!!, id)
        }
    }
}
