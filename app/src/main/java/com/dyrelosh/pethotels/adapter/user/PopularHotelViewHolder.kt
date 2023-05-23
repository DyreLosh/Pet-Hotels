package com.dyrelosh.pethotels.adapter.user

import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class PopularHotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: UserHotelModel, onItemClick: (String) -> Unit) {
        binding.nameHotelItem.text = popularHotel.name
        binding.addressHotelItem.text = popularHotel.address

        binding.root.setOnClickListener {
            onItemClick.invoke(popularHotel.id)
        }
    }
}
