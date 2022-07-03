package com.dyrelosh.pethotels.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.adapter.PopularHotelAdapter
import com.dyrelosh.pethotels.data.model.PopularHotel
import com.dyrelosh.pethotels.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding:  FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val adapter = PopularHotelAdapter()
        val popularAdapter = binding.popularRecycler
        popularAdapter.adapter = adapter


        val list = listOf(
            PopularHotel("Friends for pets", "Москва", true),
                    PopularHotel("Petwish", "Москва", true),
        PopularHotel("Friends for pets", "Москва", true),

        )
        return binding.root
    }
}