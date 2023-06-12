package com.dyrelosh.pethotels.adapter.user

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularHotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: UserHotelModel, onItemClick: (String) -> Unit) {
        binding.nameHotelItem.text = popularHotel.name
        binding.addressHotelItem.text = popularHotel.address

        binding.root.setOnClickListener {
            onItemClick.invoke(popularHotel.advertisementId)
        }
    }

}
