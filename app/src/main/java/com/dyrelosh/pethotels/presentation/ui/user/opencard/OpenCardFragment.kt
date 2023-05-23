package com.dyrelosh.pethotels.presentation.ui.user.opencard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentOpenCardBinding
import com.dyrelosh.pethotels.presentation.ui.company.viewing_ad.ViewingAdFragment
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OpenCardFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding: FragmentOpenCardBinding
    private val viewModel by viewModel<OpenCardViewModel>()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        param1 = arguments?.getString(ARG_PARAM1)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOpenCardBinding.inflate(inflater, container, false)
        binding.toMapButton.setOnClickListener {
            findNavController().navigate(R.id.action_openCardFragment_to_mapFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getOneHotel(param1.toString())

        viewModel.oneHotel.observe(viewLifecycleOwner) { oneHotel ->
            binding.oneHotelName.text = oneHotel.name
          //  binding.citiTextViewViewingAd.text = oneHotel.city
            binding.oneHotelAddress.text = oneHotel.address
            binding.oneHotelDescription.text = oneHotel.description
            //binding.numberTextViewViewingAd.text = oneHotel.number
        }

        binding.openCardBack.setOnClickListener {
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



        private const val ARG_PARAM1 = "OpenCardFragment"

    }
}

