package com.dyrelosh.pethotels.adapter.company

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemCardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel

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
      //  textViewINNCard.text = cardAd.inn
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
//        editAdCompanyCard.setOnClickListener {
//            clickListener()
//        }
    }


}