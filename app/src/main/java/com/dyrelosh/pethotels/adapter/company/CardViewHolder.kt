package com.dyrelosh.pethotels.adapter.company

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.CardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

class CardViewHolder(private val binding: CardAdBinding) : RecyclerView.ViewHolder(binding.root){
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        cardAd: HotelAddsModel?
    ) = with(binding){
        textViewAddressCard.text = cardAd?.address
        textViewNameCardAd.text = cardAd?.name
        textViewCityCard.text = cardAd?.city
        textViewNumberCard.text = cardAd?.number
        textViewDescriptionCard.text = cardAd?.description
        if(cardAd?.cat == true)
            textViewCatCard.visibility = View.VISIBLE
        if(cardAd?.dog == true)
            textViewDogCard.visibility = View.VISIBLE
        if(cardAd?.rodent == true)
            textViewRodentCard.visibility = View.VISIBLE
        if(cardAd?.other == true)
            textViewOtherCard.visibility = View.VISIBLE

    }

}