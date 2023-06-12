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
import com.dyrelosh.pethotels.databinding.FragmentSplashBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment

class CompanySplashFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding : FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        Handler(Looper.getMainLooper()).postDelayed({
//            if (PreferenceStorage(requireContext()).accessToken?.length!! > 3) {
//                findNavController().navigate(R.id.action_splashFragment_to_mainUserFragment)
//            }
//            else {
                findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
           //}

        }, 2000)
        return binding.root
    }

}