package com.dyrelosh.pethotels.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentProfileCompanyBinding

class CompanyProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileCompanyBinding.inflate(inflater, container, false)



        return binding.root
    }

}