package com.dyrelosh.pethotels.adapter.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.domain.models.PopularHotel
import com.dyrelosh.pethotels.databinding.ItemHotelBinding

class HotelAdapter: RecyclerView.Adapter<HotelViewHolder>() {

    val items = mutableListOf<PopularHotel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder(ItemHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(popularHotel: List<PopularHotel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }
}