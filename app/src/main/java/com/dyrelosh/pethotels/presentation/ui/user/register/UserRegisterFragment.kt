package com.dyrelosh.pethotels.presentation.ui.user.register

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.databinding.FragmentRegisterBinding
import com.dyrelosh.pethotels.domain.models.UserRegisterModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.HttpURLConnection

class UserRegisterFragment : UserBaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    private val validator = Validator()
    private val viewModel by viewModel<UserRegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerToLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_userRegisterFragment_to_loginFragment)
        }
        binding.backRegisterToMethod.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.registerToMainButton.setOnClickListener {
            with(binding) {
                userNameRegisterUserLayout.error =
                    validator.validateUserUserName(userNameRegisterUserEditText.text)
                passwordRegisterUserLayout.error =
                    validator.validateUserPassword(passwordRegisterUserEditText.text)
                emailRegisterUserLayout.error =
                    validator.validateUserEmail(emailRegisterUserEditText.text)
                passwordConfirmRegisterUserLayout.error =
                    validator.returnUserPassword(
                        passwordConfirmRegisterUserEditText.text,
                        passwordRegisterUserEditText.text
                    )
                if (userNameRegisterUserLayout.error == null &&
                    passwordRegisterUserLayout.error == null &&
                    emailRegisterUserLayout.error == null &&
                    passwordConfirmRegisterUserLayout.error == null
                ) {
                    viewModel.registrationHotel(
                        UserRegisterModel(
                            userName = userNameRegisterUserEditText.text.toString(),
                            email = emailRegisterUserEditText.text.toString(),
                            password = passwordRegisterUserEditText.text.toString(),
                            roles = arrayOf("User")
                        )
                    )

                }
            }
        }

        viewModel.errorCode.observe(viewLifecycleOwner) { code ->
            when (code) {
                HttpURLConnection.HTTP_BAD_REQUEST -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Пользователь с таким логином или почтой уже зарегистрирован")
                        .setPositiveButton("OK", null)
                        .show()
                }
                HttpURLConnection.HTTP_CREATED -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Вы успешно зарегистрированы")
                        .setPositiveButton("OK", null)
                        .show()
                    findNavController().navigate(R.id.action_userRegisterFragment_to_loginFragment)
                }
            }
        }
        return binding.root
    }

}