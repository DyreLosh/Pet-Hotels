package com.dyrelosh.pethotels.presentation.ui.user.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentMainContainerBinding
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.CompanyProfileFragment
import com.dyrelosh.pethotels.presentation.ui.user.favourite.FavouriteFragment
import com.dyrelosh.pethotels.presentation.ui.user.profile.UserProfileFragment
import com.dyrelosh.pethotels.presentation.ui.user.search.SearchFragment

class MainContainerFragment : Fragment() {

    lateinit var binding: FragmentMainContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainContainerBinding.inflate(inflater, container, false)
        binding.bottomNavigationUser.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.menuMain -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerUser, MainFragment())
                        .commit()
                    true
                }
                R.id.menuSearch -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerUser, SearchFragment())
                        .commit()
                    true
                }
                R.id.menuFavourite -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerUser, FavouriteFragment())
                        .commit()
                    true
                }
                R.id.menuProfile -> {
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerUser, UserProfileFragment())
                        .commit()
                    true
                }
                else -> true
            }

        }

        return binding.root
    }

}