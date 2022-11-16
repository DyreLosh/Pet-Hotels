package com.dyrelosh.pethotels.presentation.login

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.databinding.FragmentLoginCompanyBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepositoryImpl
import com.dyrelosh.pethotels.domain.companyusecase.LoginHotelUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel


class CompanyLoginFragment : Fragment() {

    lateinit var binding: FragmentLoginCompanyBinding
    private val validator = Validator()
    private lateinit var hotelLoginModel: HotelLoginModel
    private val viewModel by viewModel<CompanyLoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginCompanyBinding.inflate(inflater, container, false)
        binding.hintRegTextInput.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.inputButtonInput.setOnClickListener {
            with(binding) {
                emailLayoutInput.error = validator.validateEmailHotel(emailEditTextInput.text)
                passwordLayoutInput.error =
                    validator.validatePasswordHotel(passwordEditTextInput.text)
                if (emailLayoutInput.error == passwordLayoutInput.error) {
                    hotelLoginModel = HotelLoginModel(
                        emailHotel = emailEditTextInput.text.toString(),
                        passwordHotel = passwordEditTextInput.text.toString()
                    )
                    viewModel.loginHotel(hotelLoginModel)
                }
            }
        }
        viewModel.token.observe(viewLifecycleOwner) { tokenResult ->
            Log.d(TAG, "onCreateView: $tokenResult")
            if (tokenResult.toString() != "null") {
                Log.d(TAG, "onCreateView: true")
                Toast.makeText(context, "успешно", Toast.LENGTH_SHORT).show()
                // viewModel.setEmail(hotelLoginModel.emailHotel)
                this.findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            } else {
                Log.d(TAG, "onCreateView: false")

                Toast.makeText(context, "Не успешно", Toast.LENGTH_SHORT).show()
            }
        }
//            viewModel.auth(
//                    LoginHotelUseCase.Param(
//                        email = binding.emailEditTextInput.text.toString(),
//                        password = binding.passwordEditTextInput.text.toString()
//                    )
//                )
//                viewModel.token.observe(viewLifecycleOwner) {
//                    if (it != null) {
//                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
//                    }
//                }
//            }
        return binding.root
    }

}