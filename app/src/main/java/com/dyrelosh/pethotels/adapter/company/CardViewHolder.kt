package com.dyrelosh.pethotels.adapter.company

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.ItemCardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

class CardViewHolder(private val binding: ItemCardAdBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        cardAd: HotelAddsModel,
        clickListener: (String) -> Unit
    ) = with(binding) {
        textViewAddressCard.text = cardAd.address
        textViewNameCardAd.text = cardAd.name
        textViewCityCard.text = cardAd.city
        textViewNumberCard.text = cardAd.number
        textViewDescriptionCard.text = cardAd.description
        if (cardAd.cat)
            textViewCatCard.visibility = View.VISIBLE
        if (cardAd.dog)
            textViewDogCard.visibility = View.VISIBLE
        if (cardAd.rodent)
            textViewRodentCard.visibility = View.VISIBLE
        if (cardAd.other)
            textViewOtherCard.visibility = View.VISIBLE
        root.setOnClickListener {
            clickListener.invoke(cardAd.id)
        }
//        editAdCompanyCard.setOnClickListener {
//            clickListener()
//        }
    }


}