package com.dyrelosh.pethotels.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.databinding.FragmentProfileCompanyBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileCompanyBinding
    private val viewModel by viewModel<CompanyProfileFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileCompanyBinding.inflate(inflater, container, false)

        viewModel.hotelInfo.observe(viewLifecycleOwner) { hotelInfo ->
            if (hotelInfo != null) {
                binding.titleProfile.text = hotelInfo.name
                binding.emailTextviewCompanyProfile.text = hotelInfo.email
                binding.INNTextviewCompanyProfile.text = hotelInfo.INN
            }
        }
        viewModel.getUserInfo()

        return binding.root
    }

}