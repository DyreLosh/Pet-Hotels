package com.dyrelosh.pethotels.presentation.ui.user.opencard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dyrelosh.pethotels.databinding.FragmentOpenCardBinding
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding

class OpenCardFragment : Fragment() {

    lateinit var binding: FragmentOpenCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOpenCardBinding.inflate(inflater, container, false)

        return binding.root
    }
}

