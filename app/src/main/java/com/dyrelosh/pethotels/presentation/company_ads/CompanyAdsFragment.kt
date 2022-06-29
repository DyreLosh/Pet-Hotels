package com.dyrelosh.pethotels.presentation.company_ads

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentCompanyAdsBinding
import com.dyrelosh.pethotels.presentation.company_ads.card_ad.CardAd
import com.dyrelosh.pethotels.presentation.company_ads.card_ad.CardsAdsAdapter

class CompanyAdsFragment : Fragment() {

    lateinit var binding: FragmentCompanyAdsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompanyAdsBinding.inflate(inflater, container, false)

        val cardCompanyAd = listOf(
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            ),
            CardAd(
                nameHotel = "SwishPishPish",
                addressHotel = "RBFDEF..."
          ),
                    CardAd(
                    nameHotel = "Petwish",
            addressHotel = "Московская область, Пушкинск..."
        ),
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            ),
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            ),
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            ),
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            ),
            CardAd(
                nameHotel = "Petwish",
                addressHotel = "Московская область, Пушкинск..."
            )
        )

        binding.recyclerViewCardAd.adapter = CardsAdsAdapter(cardCompanyAd)
        binding.newAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_companyAdsFragment_to_addAdFragment)
        }
        return binding.root
    }

}