package com.dyrelosh.pethotels.presentation.ui.company.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.databinding.FragmentRegisterCompanyBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelRegisterModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyRegisterFragment : Fragment() {


    private lateinit var binding: FragmentRegisterCompanyBinding
    private val validator = Validator()
    private val viewModel by viewModel<CompanyRegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterCompanyBinding.inflate(inflater, container, false)

        binding.hintInputTextRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.registrationButtonRegistration.setOnClickListener {
            with(binding) {
                INNLayoutRegistration.error =
                    validator.validateINNHotel(INNEditTextRegistration.text)
                INNLayoutRegistration.setErrorIconDrawable(0)
                nameHotelLayoutRegistration.error =
                    validator.validateNameHotel(nameHotelEditTextRegistration.text)
                nameHotelLayoutRegistration.setErrorIconDrawable(0)
                passwordLayoutRegistration.error =
                    validator.validatePasswordHotel(passwordEditTextRegistration.text)
                passwordLayoutRegistration.setErrorIconDrawable(0)
                emailLayoutRegistration.error =
                    validator.validateEmailHotel(emailEditTextRegistration.text)
                emailLayoutRegistration.setErrorIconDrawable(0)
                returnPasswordLayoutRegistration.error =
                    validator.returnPasswordHotel(
                        returnPasswordEditTextRegistration.text,
                        passwordEditTextRegistration.text
                    )
                returnPasswordLayoutRegistration.setErrorIconDrawable(0)
                loginLayoutRegistration.error =
                    validator.validateUserUserName(loginEditTextRegistration.text)
                loginLayoutRegistration.setErrorIconDrawable(0)
                if (INNLayoutRegistration.error == null &&
                    nameHotelLayoutRegistration.error == null &&
                    passwordLayoutRegistration.error == null &&
                    emailLayoutRegistration.error == null &&
                    returnPasswordLayoutRegistration.error == null &&
                    loginLayoutRegistration.error == null
                ) {
                    viewModel.registrationHotel(
                        HotelRegisterModel(
                            inn = INNEditTextRegistration.text.toString(),
                            hotelName = nameHotelEditTextRegistration.text.toString(),
                            email = emailEditTextRegistration.text.toString(),
                            password = passwordEditTextRegistration.text.toString(),
                            userName = loginEditTextRegistration.text.toString(),
                            roles = arrayOf("Companyy")
                        )
                    )
                }
            }
        }

        viewModel.token.observe(viewLifecycleOwner) { tokenResult ->
            if (tokenResult != null) {
                this.findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
            } else {
                Toast.makeText(context, "не успешно", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}