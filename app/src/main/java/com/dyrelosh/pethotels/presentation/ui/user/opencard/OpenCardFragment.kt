package com.dyrelosh.pethotels.presentation.ui.user.opencard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.databinding.FragmentOpenCardBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OpenCardFragment : UserBaseFragment() {

    override val showBottomNavigationView = false
    lateinit var binding: FragmentOpenCardBinding
    private val viewModel by viewModel<OpenCardViewModel>()
    private var param1: String? = null
    private var number: String = ""
    private var photoId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        param1 = arguments?.getString("OOO")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOpenCardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOneHotel(param1.toString())
        viewModel.userPhoto.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.oneHotelPhoto.setImageBitmap(it)
                binding.noPhotoText.visibility = View.INVISIBLE
            }
            else {
                binding.noPhotoText.visibility = View.VISIBLE
            }
        }

        viewModel.oneHotel.observe(viewLifecycleOwner) { oneHotel ->
            binding.oneHotelName.text = oneHotel.name
            binding.oneHotelCity.text = oneHotel.city
            binding.oneHotelAddress.text = oneHotel.address
            binding.oneHotelDescription.text = oneHotel.description
            binding.phoneNumberHotel.text = oneHotel.number
            oneHotel.companyId.let { viewModel.getCompanyINN(it) }
            number = oneHotel.number
            oneHotel.photos.firstOrNull()?.let { viewModel.getHotelPhoto(it) }
            if (oneHotel.cat) binding.catCardItem.visibility = View.VISIBLE
            if (oneHotel.dog) binding.dogCardItem.visibility = View.VISIBLE
            if (oneHotel.rodent) binding.rodentCardItem.visibility = View.VISIBLE
            if (oneHotel.other) binding.otherCardItem.visibility = View.VISIBLE
        }
        viewModel.getHotelPhoto(photoId)
        viewModel.companyINN.observe(viewLifecycleOwner) {
            binding.INNNumberHotel.text = it
        }

        binding.openCardBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) {
            OpenCardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, id)
                }
            }
        }
        private const val ARG_PARAM1 = "OpenCardFragment"
    }

}

