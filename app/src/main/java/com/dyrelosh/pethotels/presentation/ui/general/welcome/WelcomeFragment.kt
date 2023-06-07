package com.dyrelosh.pethotels.presentation.ui.general.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding
    private lateinit var preference: PreferenceStorage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        preference = context?.let { PreferenceStorage(it) }!!
        val token = preference.accessToken

        binding.welcomeToLoginButton.setOnClickListener {
            if (token?.isNotEmpty() == false) {
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
            }
            else {
                findNavController().navigate(R.id.action_welcomeFragment_to_mainFragment)
            }
        }
        binding.welcomeToRegisterMethodButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_registrationMethodFragment2)
        }
        return binding.root
    }
}