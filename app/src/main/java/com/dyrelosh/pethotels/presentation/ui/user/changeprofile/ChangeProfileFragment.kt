package com.dyrelosh.pethotels.presentation.ui.user.changeprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment

class ChangeProfileFragment : UserBaseFragment() {

    override val showBottomNavigationView = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_profile, container, false)
    }

}