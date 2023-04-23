package com.dyrelosh.pethotels.presentation.ui.user.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentRegisterBinding

class UserRegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerToLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_userRegisterFragment_to_loginFragment)
        }
        binding.registerToMainButton.setOnClickListener {
            findNavController().navigate(R.id.action_userRegisterFragment_to_mainContainerFragment)
        }

        return binding.root
    }

}