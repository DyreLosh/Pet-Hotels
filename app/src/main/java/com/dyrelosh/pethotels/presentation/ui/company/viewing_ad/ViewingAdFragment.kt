package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding
 import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewingAdFragment : Fragment() {

    lateinit var binding: FragmentViewingAdBinding
    private val viewModel by viewModel<CompanyViewingAdViewModel>()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
             param1 = arguments?.getString(ARG_PARAM1)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewingAdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAddInfo(param1.toString())

        viewModel.addInfo.observe(viewLifecycleOwner) { addInfo ->
            binding.titleViewingAd.text = addInfo.name
            binding.citiTextViewViewingAd.text = addInfo.city
            binding.addressTextViewViewingAd.text = addInfo.address
            binding.descriptionTextViewViewingAd.text = addInfo.description
            binding.numberTextViewViewingAd.text = addInfo.number
        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) {
            ViewingAdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, id)
                }
            }
        }
        private const val ARG_PARAM1 = "ViewingAdFragment"

    }

}
