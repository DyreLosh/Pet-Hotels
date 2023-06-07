package com.dyrelosh.pethotels.presentation.ui.company.add_ad

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyrelosh.pethotels.domain.companymodels.Hotel
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
    private val setHotelPhotoUseCase: SetHotelPhotoUseCase,
) : ViewModel() {
    private val token = getTokenHotelUseCase.execute()

    private val _appendAddAction: MutableLiveData<Hotel> =
        MutableLiveData<Hotel>()
    val appendAddAction: LiveData<Hotel> = _appendAddAction

    private var hotelPhoto: MultipartBody.Part? = null
    fun appendAdd(hotelAppendAddModel: HotelAppendAddModel) {
       // _appendAddAction.value = appendAddUseCase.execute(token!!, hotelAppendAddModel)
        viewModelScope.launch {
            //val result =
             appendAddUseCase.execute(token!!, hotelAppendAddModel)
//            hotelPhoto?.let {
//                setHotelPhotoUseCase.execute(
//                    SetHotelPhotoUseCase.Params(
//                        token,
//                        it,
//                        result.id
//                    )
//                )
//            }
        }
    }

//    private var _userPhotoLoad: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
//    val userPhotoLoad: LiveData<Boolean> = _userPhotoLoad
//    fun setHotelPhoto(imageUrl: String?, id: String) {
//        viewModelScope.launch {
//            _userPhotoLoad.value =
//                setHotelPhotoUseCase.execute(SetHotelPhotoUseCase.Params(token!!, imageUrl, id))
//        }
//    }
//
//    private var _userPhoto: MutableLiveData<Bitmap> = MutableLiveData<Bitmap>()
//    val userPhoto: LiveData<Bitmap> = _userPhoto
//    fun getHotelPhoto(id: String) {
//        viewModelScope.launch {
//            _userPhoto.value = getHotelPhotoUseCase.execute(token!!, id)
//        }
//    }
}
