package com.dyrelosh.pethotels.adapter.company

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.databinding.CardAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel

class CardsAdsAdapter(
//    private val items: List<CardAd>
    ) : RecyclerView.Adapter<CardViewHolder>() {

    private var cardsAd = mutableListOf<HotelAddsModel?>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CardViewHolder {
        return CardViewHolder(
            CardAdBinding.inflate(
            LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardsAd[position])
    }

    override fun getItemCount(): Int = cardsAd.size

    fun submitList(listAdModel: MutableList<HotelAddsModel>) {
        cardsAd.clear()
        cardsAd.addAll(listAdModel)

    }
}
