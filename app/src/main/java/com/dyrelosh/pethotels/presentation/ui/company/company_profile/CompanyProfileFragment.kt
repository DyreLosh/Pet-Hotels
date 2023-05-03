package com.dyrelosh.pethotels.presentation.ui.company.company_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
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
                binding.INNTextviewCompanyProfile.text = hotelInfo.inn
                }
        }
        viewModel.getUserInfo()

       binding.editIcon.setOnClickListener {
           findNavController().navigate(R.id.action_mainFragment_to_editProfileCompanyFragment)
       }

        return binding.root
    }

}