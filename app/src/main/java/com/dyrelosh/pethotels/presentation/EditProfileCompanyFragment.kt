package com.dyrelosh.pethotels.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dyrelosh.pethotels.databinding.FragmentEditProfileCompanyBinding

class EditProfileCompanyFragment : Fragment() {

    lateinit var binding: FragmentEditProfileCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileCompanyBinding.inflate(inflater, container, false)

        return binding.root
    }
}

