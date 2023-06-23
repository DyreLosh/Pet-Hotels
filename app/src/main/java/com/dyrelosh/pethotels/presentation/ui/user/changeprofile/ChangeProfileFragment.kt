package com.dyrelosh.pethotels.presentation.ui.user.changeprofile

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentChangeProfileBinding
import com.dyrelosh.pethotels.domain.companymodels.ChangeEmailModel
import com.dyrelosh.pethotels.domain.companymodels.ChangePasswordModel
import com.dyrelosh.pethotels.domain.companymodels.ChangeUserNameModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeProfileFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding: FragmentChangeProfileBinding
    private val viewModel by viewModel<ChangeProfileViewModel>()
    private var userId = ""
    private var userEmail = ""
    private var userName = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeProfileBinding.inflate(inflater, container, false)
        binding.backToProfileInChangeProfileButton.setOnClickListener {
            findNavController().popBackStack()
        }
        val validator = Validator()
        viewModel.getUserInfo()
        viewModel.response.observe(viewLifecycleOwner) { info ->
            binding.newUserNameChangeProfileEdit.setText(info.userName)
            binding.newEmailChangeProfileEdit.setText(info.email)
            userId = info.id
            userEmail = info.email
            userName = info.userName
        }
        binding.changeUserInfoButton.setOnClickListener {
            with(binding) {
                newEmailChangeProfileInput.error =
                    validator.validateUserEmail(newEmailChangeProfileEdit.text)
                newUserNameChangeProfileInput.error =
                    validator.validateUserUserName(newUserNameChangeProfileEdit.text)

                if (newEmailChangeProfileInput.error == null && newUserNameChangeProfileInput.error == null
                ) {
                    viewModel.changeUserEmail(userId,
                        binding.newEmailChangeProfileEdit.text.toString()
                    )
                    viewModel.changeUserName(userId, binding.newUserNameChangeProfileEdit.text.toString())
                    AlertDialog.Builder(context).setTitle("Вы успешно сменили данные")
                        .setPositiveButton("Ok", null).show()
                    findNavController().popBackStack()
                } else {
                    AlertDialog.Builder(context).setTitle("Проверьте данные")
                        .setPositiveButton("Ok", null).show()
                }
            }
        }

        return binding.root
    }


}