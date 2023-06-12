package com.dyrelosh.pethotels.presentation.ui.user.changepassword

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
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentChangePasswordBinding
import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangePasswordFragment : UserBaseFragment() {
    override val showBottomNavigationView = false
    val validator = Validator()
    lateinit var binding: FragmentChangePasswordBinding
    private val viewModel by viewModel<ChangePasswordViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        binding.backToProfileInChangeProfileButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.changeUserPasswordButton.setOnClickListener {
            with(binding) {
                userOldPasswordInputLayout.error =
                    validator.validateUserPassword(userOldPasswordEditText.text)
                userNewPasswordInputLayout.error =
                    validator.validateUserPassword(userNewPasswordEditText.text)
                binding.userOldPasswordInputLayout.error =
                    if (userOldPasswordEditText.text.toString() ==
                        PreferenceStorage(requireContext()).password.toString()
                    ) "" else "Неверный старый пароль"

                if (userOldPasswordInputLayout.error == null && userNewPasswordInputLayout.error == null &&
                    userOldPasswordEditText.text.toString() == PreferenceStorage(requireContext())
                        .password.toString()
                ) {
                    viewModel.changePassword(
                        ChangePasswordModel(
                            email = PreferenceStorage(requireContext()).email.toString(),
                            currentPassword = userOldPasswordEditText.text.toString(),
                            newPassword = userNewPasswordEditText.text.toString()
                        )
                    )
                    AlertDialog.Builder(context).setTitle("Вы успешно сменили пароль")
                        .setPositiveButton("Ok", null).show()
                    findNavController().navigate(R.id.action_changePasswordFragment_to_loginFragment)
                } else {
                    AlertDialog.Builder(context).setTitle("Проверьте данные")
                        .setPositiveButton("Ok", null).show()
                }
            }
        }
        return binding.root
    }

}