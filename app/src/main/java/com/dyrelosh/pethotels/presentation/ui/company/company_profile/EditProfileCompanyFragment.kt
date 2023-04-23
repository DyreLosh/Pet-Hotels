package com.dyrelosh.pethotels.presentation.ui.company.company_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.databinding.FragmentEditProfileCompanyBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelInfoModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditProfileCompanyFragment : Fragment() {

    lateinit var binding: FragmentEditProfileCompanyBinding
    private val validator = Validator()
    private val viewModel by viewModel<EditProfileCompanyFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileCompanyBinding.inflate(inflater, container, false)

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveButtonEditProfile.setOnClickListener {
            with(binding) {
                nameHotelLayoutEditProfile.error =
                    validator.validateNameHotel(nameHotelEditTextEditProfile.text)
                emailLayoutEditProfile.error =
                    validator.validateEmailHotel(emailEditTextEditProfile.text)
                INNLayoutEditProfile.error =
                    validator.validateINNHotel(INNEditTextEditProfile.text)
                if (INNLayoutEditProfile.error == null &&
                    nameHotelLayoutEditProfile.error == null &&
                    emailLayoutEditProfile.error == null
                ) {
                    viewModel.editProfileCompany(
                        HotelInfoModel(
                            inn = INNEditTextEditProfile.text.toString(),
                            name = nameHotelEditTextEditProfile.text.toString(),
                            email = emailEditTextEditProfile.text.toString()
                        )
                    )

                }
            }
        }

        return binding.root
    }
}


