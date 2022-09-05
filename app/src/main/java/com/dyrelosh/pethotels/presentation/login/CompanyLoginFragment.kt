package com.dyrelosh.pethotels.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentLoginCompanyBinding

class CompanyLoginFragment : Fragment() {

    lateinit var binding: FragmentLoginCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginCompanyBinding.inflate(inflater, container, false)
        binding.hintRegTextInput.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.inputButtonInput.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
        return binding.root
    }

}