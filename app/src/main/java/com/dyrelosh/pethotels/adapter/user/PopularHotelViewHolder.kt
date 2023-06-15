package com.dyrelosh.pethotels.adapter.user

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.icu.number.NumberRangeFormatter.with
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.ItemHotelBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*


class PopularHotelViewHolder(private val binding: ItemHotelBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(popularHotel: UserHotelModel, onItemClick: (String) -> Unit) {
        binding.nameHotelItem.text = popularHotel.name
        binding.addressHotelItem.text = popularHotel.address
        var p = popularHotel.photos

        if (p.size != 0) {
            Picasso.get()
                .load(bitmapToFile(p.get(0)!!))
                .placeholder(R.drawable.ic_app_logo)
                .into(binding.hotelImage)
        }

        binding.root.setOnClickListener {
            onItemClick.invoke(popularHotel.advertisementId)
        }
    }

    fun bitmapToFile(bitmap: Bitmap): File? {
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
