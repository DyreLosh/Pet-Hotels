package com.dyrelosh.pethotels.presentation.company_ads

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentCompanyAdsBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.presentation.add_ad.AppendAddFragment
import com.dyrelosh.pethotels.presentation.company_ads.card_ad.CardsAdsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyAdsFragment : Fragment() {

    lateinit var binding: FragmentCompanyAdsBinding
    private val listAdd = mutableListOf<HotelAddsModel>()
    private val viewModel by viewModel<CompanyAdsViewModel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompanyAdsBinding.inflate(inflater, container, false)
        viewModel.getAdds()
        val adapter = CardsAdsAdapter()
        binding.recyclerViewCardAd.adapter = adapter

        viewModel.responseAdds.observe(viewLifecycleOwner){ responseAdds ->
            listAdd.clear()
            listAdd.addAll(responseAdds)
            adapter.submitList(listAdd)
        }

//        val cardCompanyAd = listOf(
//
//            CardAd(
//                nameHotel = "Petwish",
//                addressHotel = "Московская область, Пушкинск..."
//            )
//        )
//
//        binding.recyclerViewCardAd.adapter = CardsAdsAdapter(cardCompanyAd)
        binding.newAddButton.setOnClickListener {
//            val intent = Intent(activity, AppendAddFragment::class.java)
//            startActivity(intent)
            findNavController().navigate(R.id.action_mainFragment_to_appendAddFragment)
        }
        return binding.root
    }

}