package com.dyrelosh.pethotels.presentation.ui.user.opencard

import android.Manifest.permission.CALL_PHONE
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
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
        /* binding.toMapButton.setOnClickListener {
             findNavController().navigate(R.id.action_openCardFragment_to_mapFragment)
         }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOneHotel(param1.toString())
        viewModel.userPhoto.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.oneHotelPhoto.setImageBitmap(it)
            }
            else {

            }
        }

        viewModel.oneHotel.observe(viewLifecycleOwner) { oneHotel ->
            binding.oneHotelName.text = oneHotel.name
            binding.oneHotelCity.text = oneHotel.city
            binding.oneHotelAddress.text = oneHotel.address
            binding.oneHotelDescription.text = oneHotel.description
            number = oneHotel.number
            oneHotel.photos.firstOrNull()?.let { viewModel.getHotelPhoto(it) }
            if (oneHotel.cat) binding.catCardItem.visibility = View.VISIBLE
            if (oneHotel.dog) binding.dogCardItem.visibility = View.VISIBLE
            if (oneHotel.rodent) binding.rodentCardItem.visibility = View.VISIBLE
            if (oneHotel.other) binding.otherCardItem.visibility = View.VISIBLE
            /* when {
                 oneHotel.cat -> {binding.catCardItem.visibility = View.VISIBLE}
                 oneHotel.dog -> {binding.dogCardItem.visibility = View.VISIBLE}
                 oneHotel.rodent -> {binding.rodentCardItem.visibility = View.VISIBLE}
                 oneHotel.other -> {binding.otherCardItem.visibility = View.VISIBLE}
             }*/
        }
        binding.zakazatHotel.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(number)
            /*builder.setPositiveButton("Позвонить", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$number")
                if (ContextCompat.checkSelfPermission(requireActivity(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent)
                } else {
                    val requestPermissions = { CALL_PHONE }
            }

            })*/
            builder.setNegativeButton("Отмена", null)
            builder.show()
        }

        viewModel.getHotelPhoto(photoId)

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

