package com.dyrelosh.pethotels.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.data.model.PopularHotel
import com.dyrelosh.pethotels.databinding.ItemHotelBinding

class HotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: PopularHotel) {
        binding.nameHotelItem.text = popularHotel.nameHotel
        binding.addressHotelItem.text = popularHotel.address
    }

}
