package com.dyrelosh.pethotels.presentation.ui.user.registrationmethod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentRegistrationMethodBinding

class RegistrationMethodFragment : Fragment() {
    //TODO название фрагмента не понятное
    private lateinit var binding: FragmentRegistrationMethodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationMethodBinding.inflate(inflater, container, false)
        binding.methodToRegisterButton.setOnClickListener {
            findNavController().navigate(R.id.action_registrationMethodFragment2_to_userRegisterFragment)
        }
        binding.methodToCompanyButton.setOnClickListener {
            findNavController().navigate(R.id.action_registrationMethodFragment2_to_registerFragment)
        }
        return binding.root
    }

}