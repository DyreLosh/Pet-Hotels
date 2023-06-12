package com.dyrelosh.pethotels.adapter.company

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.ItemCardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

class CardsAdsAdapter() : RecyclerView.Adapter<CardViewHolder>() {

    private var cardsAd = mutableListOf<Hotel>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CardViewHolder {
        return CardViewHolder(
            ItemCardAdBinding.inflate(
            LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    var itemClick: (String) -> Unit = {}

     override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardsAd[position], itemClick) }



    override fun getItemCount(): Int = cardsAd.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(listAdModel: List<Hotel>) {
        cardsAd.clear()
        cardsAd.addAll(listAdModel)
        notifyDataSetChanged()
    }
}
