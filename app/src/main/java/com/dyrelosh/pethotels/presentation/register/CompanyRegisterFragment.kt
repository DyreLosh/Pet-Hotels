package com.dyrelosh.pethotels.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentRegisterCompanyBinding

class CompanyRegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterCompanyBinding.inflate(inflater, container, false)
        binding.hintInputTextRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.registrationButtonRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
        }
        return binding.root
    }

}