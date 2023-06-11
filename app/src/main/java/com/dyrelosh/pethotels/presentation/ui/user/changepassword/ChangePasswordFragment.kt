package com.dyrelosh.pethotels.presentation.ui.user.changepassword

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.data.api.preference.PreferenceStorage
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
                if (userOldPasswordEditText.error == null && userNewPasswordEditText.error == null &&
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
                }
                else {
                    AlertDialog.Builder(context).setTitle("Неверный старый пароль")
                        .setPositiveButton("Ok", null)
                }
                AlertDialog.Builder(context).setTitle("Вы успешно сменили пароль")
                    .setPositiveButton("Ok", null)
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

}