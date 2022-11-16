package com.dyrelosh.pethotels.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding

class ViewingAdFragment : Fragment() {

    lateinit var binding: FragmentViewingAdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewingAdBinding.inflate(inflater, container, false)

        return binding.root
    }
}

