package com.dyrelosh.pethotels.presentation.ui.user.changeprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentChangeProfileBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeProfileFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding: FragmentChangeProfileBinding
    private val viewModel by viewModel<ChangeProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeProfileBinding.inflate(inflater, container, false)
        viewModel.getUserInfo()
        viewModel.response.observe(viewLifecycleOwner) { info ->
            binding.newUserNameChangeProfileEdit.hint = info.userName
            binding.newEmailChangeProfileEdit.hint = info.email
        }
        return binding.root
    }



}