 package com.dyrelosh.pethotels.presentation.ui.user.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentProfileBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


 class UserProfileFragment : UserBaseFragment() {

     lateinit var binding: FragmentProfileBinding
     override val showBottomNavigationView = true
     private val viewModel by viewModel<UserProfileViewModel>()

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
        viewModel.getUserInfo()
        viewModel.response.observe(viewLifecycleOwner) {info ->
            binding.emailUserInfo.text = info.email
            binding.userLoginInfo.text = info.userName
        }

        binding.backInAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFragment_to_welcomeFragment)
            PreferenceStorage(requireContext()).clearPreference()
        }

        return binding.root
    }

}