package com.dyrelosh.pethotels.adapter.user

import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.domain.models.PopularHotel
import com.dyrelosh.pethotels.databinding.ItemHotelBinding

class PopularHotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: PopularHotel) {
        binding.nameHotelItem.text = popularHotel.nameHotel
        binding.addressHotelItem.text = popularHotel.address
    }



}
