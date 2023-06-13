package com.dyrelosh.pethotels.presentation.login

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
import com.dyrelosh.pethotels.databinding.FragmentLoginCompanyBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelLoginModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class CompanyLoginFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    private lateinit var binding: FragmentLoginCompanyBinding
    private val validator = Validator()
    private lateinit var hotelLoginModel: HotelLoginModel
    private val viewModel by viewModel<CompanyLoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginCompanyBinding.inflate(inflater, container, false)

        binding.hintRegTextInput.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationMethodFragment2)
        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.inputButtonInput.setOnClickListener {
            with(binding) {
                emailLayoutInput.error = validator.validateUserEmail(emailEditTextInput.text)
                passwordLayoutInput.error =
                    validator.validateUserPassword(passwordEditTextInput.text)
                if (emailLayoutInput.error == passwordLayoutInput.error) {
                    viewModel.loginHotel(
                        HotelLoginModel(
                            email = emailEditTextInput.text.toString(),
                            password = passwordEditTextInput.text.toString()
                        )
                    )
                }
            }
        }
        viewModel.token.observe(viewLifecycleOwner) { tokenResult ->
            if (tokenResult != null) {
                when (tokenResult.role.first()) {
                    "User" -> {
                        this.findNavController()
                            .navigate(R.id.action_loginFragment_to_mainUserFragment)
                        Toast.makeText(context, tokenResult.token.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                    "Companyy" -> this.findNavController()
                        .navigate(R.id.action_loginFragment_to_mainFragment)
                    else -> AlertDialog.Builder(requireContext())
                        .setTitle("Введите правильные данные для входа")
                        .setPositiveButton("OK", null)
                        .show()
                }
            } else AlertDialog.Builder(requireContext()).setTitle("Проверьте введенные данны")
                .setPositiveButton("OK", null).show()
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