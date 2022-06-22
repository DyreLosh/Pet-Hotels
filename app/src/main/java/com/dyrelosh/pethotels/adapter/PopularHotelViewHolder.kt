package com.dyrelosh.pethotels.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.adapter.model.PopularHotel
import com.dyrelosh.pethotels.databinding.ItemHotelBinding

class PopularHotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: PopularHotel) {
        binding.nameHotelItem.text = popularHotel.nameHotel
        binding.addresHotelItem.text = popularHotel.address
        //binding.likeItem = popularHotel.like
    }



}
