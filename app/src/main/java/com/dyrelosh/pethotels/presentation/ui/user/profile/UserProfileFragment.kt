 package com.dyrelosh.pethotels.presentation.ui.user.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentProfileBinding


 class UserProfileFragment : Fragment() {

     lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.editProfileCard.setOnClickListener{
            findNavController().navigate(R.id.action_userProfileFragment_to_changeProfileFragment)
        }
        binding.editPasswordCard.setOnClickListener{
            findNavController().navigate(R.id.action_userProfileFragment_to_changePasswordFragment)
        }

        return binding.root
    }

}