package com.dyrelosh.pethotels.presentation.company_ads.card_ad

import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.CardAdBinding

class CardViewHolder(private val binding: CardAdBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(cardAd: CardAd) = with(binding){
        textViewAddressCard.text = cardAd.addressHotel
        textViewNameCardAd.text = cardAd.nameHotel
    }
}