package com.dyrelosh.pethotels.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentMainCompanyBinding
import com.dyrelosh.pethotels.presentation.company_ads.CompanyAdsFragment
import com.dyrelosh.pethotels.presentation.company_ads_empty.CompanyAdsEmptyFragment
import com.dyrelosh.pethotels.presentation.profile.CompanyProfileFragment

class CompanyMainFragment : Fragment() {

    lateinit var binding: FragmentMainCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCompanyBinding.inflate(inflater, container, false)

        binding.bottomNavigationCompany.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.menuHotel -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerViewCompany, CompanyProfileFragment())
                        .commit()
                    true
                }
                R.id.menuAd -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerViewCompany, CompanyAdsEmptyFragment())
                        .commit()
                    true
                }
                else -> true
            }

        }
        return binding.root
    }

}