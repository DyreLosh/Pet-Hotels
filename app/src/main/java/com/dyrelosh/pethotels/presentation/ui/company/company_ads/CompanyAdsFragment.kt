package com.dyrelosh.pethotels.presentation.ui.company.company_ads

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentCompanyAdsBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.adapter.company.CardsAdsAdapter
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
        val adapter = CardsAdsAdapter{ -> findNavController().navigate(R.id.action_mainFragment_to_viewingAdFragment)}
        binding.recyclerViewCardAd.adapter = adapter

        viewModel.responseAdds.observe(viewLifecycleOwner){ responseAdds ->
            listAdd.clear()
            listAdd.addAll(responseAdds)
            adapter.submitList(listAdd)
        }


        binding.newAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_appendAddFragment)
        }
        return binding.root
    }

}