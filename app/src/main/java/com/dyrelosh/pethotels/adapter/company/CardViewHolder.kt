package com.dyrelosh.pethotels.adapter.company

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.os.Environment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.ItemCardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.squareup.picasso.Picasso
import com.yandex.mapkit.uri.Uri
import java.io.*
import java.net.HttpCookie.parse
import java.util.*
import kotlin.time.Duration.Companion.parse


class CardViewHolder(private val binding: ItemCardAdBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        cardAd: Hotel,
        clickListener: (String) -> Unit
    ) = with(binding) {
        textViewAddressCard.text = cardAd.address
        textViewNameCardAd.text = cardAd.name
        textViewCityCard.text = cardAd.city
        textViewNumberCard.text = cardAd.number
        var p = cardAd.photos

        if(p.size != 0){
            Picasso.with(itemView.context)
                .load(bitmapToFile(p.get(0)!!))
                .placeholder(R.drawable.ic_app_logo)
                .into(PhotoAd)
        }

        if (cardAd.cat)
            textViewCatCard.visibility = View.VISIBLE
        if (cardAd.dog)
            textViewDogCard.visibility = View.VISIBLE
        if (cardAd.rodent)
            textViewRodentCard.visibility = View.VISIBLE
        if (cardAd.other)
            textViewOtherCard.visibility = View.VISIBLE
        root.setOnClickListener {
            clickListener.invoke(cardAd.advertisementId)
        }
    }

    fun bitmapToFile(bitmap: Bitmap): File? {
        val wrapper = ContextWrapper(itemView.context)
        var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
        file = File(file,"${UUID.randomUUID()}.jpg")
        val stream: OutputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG,25,stream)
        stream.flush()
        stream.close()
        return file
    }

}
