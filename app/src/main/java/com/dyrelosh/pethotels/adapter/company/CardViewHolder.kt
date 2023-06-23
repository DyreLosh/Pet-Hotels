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

        var animalOne = mutableListOf<String>()
        var c = 0
        if (cardAd.cat){
            animalOne.add("Кошки ")
            c += 1
        }
        if (cardAd.dog){
            animalOne.add("Собаки ")
            c += 1
        }
        if (cardAd.rodent){
            animalOne.add("Грызуны ")
            c += 1
        }
        if (cardAd.other){
            animalOne.add("Другие ")
            c += 1
        }
        if(c == 1){
            textViewCatCard.text = animalOne[0]
        }
        if(c==2){
            textViewCatCard.text = animalOne[0] + animalOne[1]
        }
        if(c==3){
            textViewCatCard.text = animalOne[0] + animalOne[1] + "\n" + animalOne[2]
        }
        if(c==4){
            textViewCatCard.text = animalOne[0] + animalOne[1] + "\n" + animalOne[2] + animalOne[3]
        }
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
