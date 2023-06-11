package com.dyrelosh.pethotels.adapter.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class HotelAdapter(var mList: List<UserHotelModel>): RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    val items = mutableListOf<UserHotelModel>()
    var onItemClick: (String) -> Unit = {}

    inner class HotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(popularHotel: UserHotelModel, onItemClick: (String) -> Unit) {
            binding.nameHotelItem.text = popularHotel.name
            binding.addressHotelItem.text = popularHotel.address

            binding.root.setOnClickListener {
                onItemClick.invoke(popularHotel.advertisementId)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder(
            ItemHotelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    override fun getItemCount(): Int = items.size

    fun submitList(popularHotel: List<UserHotelModel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }
}