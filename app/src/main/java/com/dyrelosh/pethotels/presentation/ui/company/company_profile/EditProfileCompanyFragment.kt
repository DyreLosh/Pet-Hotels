package com.dyrelosh.pethotels.presentation.ui.company.company_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.common.Validator
import com.dyrelosh.pethotels.databinding.FragmentEditProfileCompanyBinding
import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companymodels.HotelEditModel
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

        viewModel.hotelInfo.observe(viewLifecycleOwner) { hotelInfo ->
            if (hotelInfo != null) {
                binding.INNEditTextEditProfile.setText(hotelInfo.inn)
                binding.nameHotelEditTextEditProfile.setText(hotelInfo.hotelName)
                binding.emailEditTextEditProfile.setText(hotelInfo.email)
            }
        }
        viewModel.getUserInfo()
        binding.passButtonEditProfile.setOnClickListener {
            with(binding){
                if(passwordLayoutEditProfile.visibility == View.VISIBLE){
                    passwordLayoutEditProfile.visibility = View.INVISIBLE
                    passwordNewLayoutEditProfile.visibility = View.INVISIBLE
                } else {
                    passwordLayoutEditProfile.visibility = View.VISIBLE
                    passwordNewLayoutEditProfile.visibility = View.VISIBLE
                }
            }
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
                        HotelEditModel(
                            inn = INNEditTextEditProfile.text.toString(),
                            hotelName = nameHotelEditTextEditProfile.text.toString(),
                            email = emailEditTextEditProfile.text.toString()
                        )
                    )
                } else {
                    Toast.makeText(context, "Проверьте данные", Toast.LENGTH_SHORT).show()
                }
                if(passwordLayoutEditProfile.visibility == View.VISIBLE) {
                    passwordLayoutEditProfile.error =
                        validator.validateAdd(passwordEditTextEditProfile.text)
                    passwordNewLayoutEditProfile.error =
                        validator.validateAdd(passwordNewEditTextEditProfile.text)
                }
                if(passwordLayoutEditProfile.error == null &&
                    passwordNewLayoutEditProfile.error == null){
                    viewModel.changePassword(
                        ChangePasswordModel(
                            email = emailEditTextEditProfile.text.toString(),
                            currentPassword = passwordEditTextEditProfile.text.toString(),
                            newPassword = passwordNewEditTextEditProfile.text.toString()
                        )
                    )
                } else {
                    Toast.makeText(context, "Проверьте данные", Toast.LENGTH_SHORT).show()
                }

                findNavController().popBackStack()
            }
        }
        return binding.root
    }
}


