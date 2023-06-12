package com.dyrelosh.pethotels.adapter.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel

class HotelAdapter(private val cellClickListener: CellClickListener): RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    val items = mutableListOf<UserHotelModel>()
    var onItemClick: ((UserHotelModel) -> Unit)? = {}

    inner class HotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(popularHotel: UserHotelModel, onItemClick: ((UserHotelModel) -> Unit)?) {
            binding.nameHotelItem.text = popularHotel.name
            binding.addressHotelItem.text = popularHotel.address


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
        holder.itemView.setOnClickListener {
                cellClickListener.onCellClickListener(items[position])
            }

    }

    override fun getItemCount(): Int = items.size

    fun submitList(popularHotel: List<UserHotelModel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }
}