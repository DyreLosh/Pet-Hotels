package com.dyrelosh.pethotels.presentation.company_ads_empty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentCompanyAdsEmptyBinding

class CompanyAdsEmptyFragment : Fragment() {

    lateinit var binding: FragmentCompanyAdsEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompanyAdsEmptyBinding.inflate(inflater, container, false)
        binding.newAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_companyAdsEmptyFragment_to_addAdFragment)
        }
        return binding.root
    }

}