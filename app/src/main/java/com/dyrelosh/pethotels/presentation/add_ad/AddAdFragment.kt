package com.dyrelosh.pethotels.presentation.add_ad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentAddAdBinding

class AddAdFragment : Fragment() {

    lateinit var binding: FragmentAddAdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAdBinding.inflate(inflater, container, false)
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

}