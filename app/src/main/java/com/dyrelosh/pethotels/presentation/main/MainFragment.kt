package com.dyrelosh.pethotels.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentMainBinding
import com.dyrelosh.pethotels.presentation.company_ads_empty.CompanyAdsEmptyFragment
import com.dyrelosh.pethotels.presentation.profile.ProfileFragment

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.bottomNavigationCompany.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.menuHotel -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerViewCompany, ProfileFragment())
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