package com.dyrelosh.pethotels.adapter.user

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class HotelAdapter(private val cellClickListener: CellClickListener): RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    val items = mutableListOf<Hotel>()
    var onItemClick: ((Hotel) -> Unit)? = {}

    inner class HotelViewHolder(private val binding: ItemHotelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(popularHotel: Hotel, onItemClick: ((Hotel) -> Unit)?) {
            binding.nameHotelItem.text = popularHotel.name
            binding.addressHotelItem.text = popularHotel.address
            var p = popularHotel.photos

            if (p.size != 0) {
                Picasso.with(itemView.context)
                    .load(bitmapToFile(p.get(0)!!))
                    .placeholder(R.drawable.ic_app_logo)
                    .into(binding.hotelImage)
            }
        }
        fun bitmapToFile(bitmap: Bitmap): File {
            val wrapper = ContextWrapper(itemView.context)
            var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
            file = File(file, "${UUID.randomUUID()}.jpg")
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 25, stream)
            stream.flush()
            stream.close()
            return file
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

    fun submitList(popularHotel: List<Hotel>) {
        items.clear()
        items.addAll(popularHotel)
        notifyDataSetChanged()
    }
}