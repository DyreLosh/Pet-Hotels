package com.dyrelosh.pethotels.presentation.ui.company.register

import android.app.AlertDialog
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
import java.net.HttpURLConnection

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
                nameHotelLayoutRegistration.error =
                    validator.validateNameHotel(nameHotelEditTextRegistration.text)
                passwordLayoutRegistration.error =
                    validator.validatePasswordHotel(passwordEditTextRegistration.text)
                emailLayoutRegistration.error =
                    validator.validateEmailHotel(emailEditTextRegistration.text)
                returnPasswordLayoutRegistration.error =
                    validator.returnPasswordHotel(
                        returnPasswordEditTextRegistration.text,
                        passwordEditTextRegistration.text
                    )
                if (INNLayoutRegistration.error == null &&
                    nameHotelLayoutRegistration.error == null &&
                    passwordLayoutRegistration.error == null &&
                    emailLayoutRegistration.error == null &&
                    returnPasswordLayoutRegistration.error == null
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

        viewModel.errorCode.observe(viewLifecycleOwner) { code ->
            when (code) {
                HttpURLConnection.HTTP_BAD_REQUEST -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Пользователь с таким данными уже зарегистрирован")
                        .setPositiveButton("OK", null)
                        .show()
                }
                HttpURLConnection.HTTP_CREATED -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Вы успешно зарегистрированы")
                        .setPositiveButton("OK", null)
                        .show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }
        }
        return binding.root
    }
}