package com.dyrelosh.pethotels.presentation.ui.user.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.adapter.user.PopularHotelAdapter
import com.dyrelosh.pethotels.databinding.FragmentViewPagerBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewPagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        return binding.root
    }

}

