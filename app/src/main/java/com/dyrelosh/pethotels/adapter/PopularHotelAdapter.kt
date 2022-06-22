package com.dyrelosh.pethotels.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.adapter.model.PopularHotel
import com.dyrelosh.pethotels.databinding.ItemHotelBinding

class PopularHotelAdapter : RecyclerView.Adapter<PopularHotelViewHolder>() {

    val items = mutableListOf<PopularHotel>()

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
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(popularHotel: List<PopularHotel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }
}