package com.dyrelosh.pethotels.adapter.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class PopularHotelAdapter : RecyclerView.Adapter<PopularHotelViewHolder>() {

    val items = mutableListOf<UserHotelModel>()
    var onItemClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHotelViewHolder {
        return PopularHotelViewHolder(
            ItemHotelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularHotelViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    override fun getItemCount(): Int = items.size

    fun submitList(popularHotel: List<UserHotelModel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }


}