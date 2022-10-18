package com.dyrelosh.pethotels.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentLoginCompanyBinding
import com.dyrelosh.pethotels.domain.UserRepository
import com.dyrelosh.pethotels.domain.userusecase.AuthUserUseCase

class CompanyLoginFragment : Fragment() {

    lateinit var binding: FragmentLoginCompanyBinding

    private val userRepository = UserRepository()
    private val authUserUseCase = AuthUserUseCase(userRepository)
    val viewModel = CompanyLoginFragmentViewModel(authUserUseCase)

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
            viewModel.auth(
                AuthUserUseCase.Param(
                    email = binding.emailEditTextInput.text.toString(),
                    password = binding.passwordEditTextInput.text.toString()
                )
            )
            viewModel.token.observe(viewLifecycleOwner) {
                if (it != null) {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }
            }


        }
        return binding.root
    }

}