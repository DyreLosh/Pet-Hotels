package com.dyrelosh.pethotels.presentation.ui.general.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentSplashBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment

class CompanySplashFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        val pref = PreferenceStorage(requireContext())
        binding.imageView.setOnClickListener {
            PreferenceStorage(requireContext()).clearPreference()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            if (pref.accessToken?.length!! > 3) {
                when (pref.loginRole) {
                    "User" -> {
                        findNavController().navigate(R.id.action_splashFragment_to_mainUserFragment)
                    }
                    "Companyy" -> {
                        findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                    }
                    else -> {
                        findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
                    }
                }
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 2000)
        return binding.root
    }

}