package com.dyrelosh.pethotels.presentation.ui.user.main

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentMainContainerBinding
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.dyrelosh.pethotels.presentation.ui.company.company_profile.CompanyProfileFragment
import com.dyrelosh.pethotels.presentation.ui.user.favourite.FavouriteFragment
import com.dyrelosh.pethotels.presentation.ui.user.map.MapFragment
import com.dyrelosh.pethotels.presentation.ui.user.profile.UserProfileFragment
import com.dyrelosh.pethotels.presentation.ui.user.search.SearchFragment

class MainContainerFragment : Fragment() {

    lateinit var binding: FragmentMainContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainContainerBinding.inflate(inflater, container, false)
        permission()



        return binding.root
    }

    private fun permission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED || ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ), 0
            )
            return
        }
    }
}