package com.dyrelosh.pethotels.presentation.registrationmethod

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentRegistrationMethodBinding
import com.dyrelosh.pethotels.databinding.FragmentSplashBinding

class RegistrationMethodFragment : Fragment() {

    lateinit var binding: FragmentRegistrationMethodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationMethodBinding.inflate(inflater, container, false)
        binding.companyButtonRegMeth.setOnClickListener {
            findNavController().navigate(R.id.action_registrationMethodFragment_to_registerFragment)
        }
        return binding.root
    }

}
