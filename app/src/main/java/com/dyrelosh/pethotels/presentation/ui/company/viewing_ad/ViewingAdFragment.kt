package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.extensions.handleImagePickerResult
import com.dyrelosh.pethotels.extensions.isStoragePermissionGranted
import com.dyrelosh.pethotels.extensions.pickImage
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewingAdFragment : Fragment() {

    lateinit var binding: FragmentViewingAdBinding
    private val viewModel by viewModel<CompanyViewingAdViewModel>()
    private var itemId: String? = null

    private val pickerResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            requireActivity().handleImagePickerResult(
                result = result,
                needPath = true,
                onSuccess = { stringUri ->
                    val uri = Uri.parse(stringUri)
                    selectedAvatarUri = uri
                    binding.PhotoAd.load(uri.path)
                    Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                },
                onFailure = { Toast.makeText(context, "Not load", Toast.LENGTH_SHORT).show() }
            )
        }
    private var selectedAvatarUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemId = arguments?.getString(CompanyAdsFragment.PAIR_KEY)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewingAdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemId?.let { viewModel.getAddInfo(it) }
        viewModel.userPhoto.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.PhotoAd.setImageBitmap(it)
            }
        }
        viewModel.addInfoID.observe(viewLifecycleOwner) { addInfo ->
           // viewModel.getHotelPhoto(addInfo.imageId)
            with(binding){

                nameHotelEditTextAdd.setText(addInfo.imageId)
                cityHotelEditTextAdd.setText(addInfo.city)
                addressHotelEditTextAdd.setText(addInfo.address)
                numberEditText.setText(addInfo.number)
                hintDescribeAddAd.setText(addInfo.description)
                if (addInfo.dog)
                    checkboxDogAddAd.toggle()
                if (addInfo.cat)
                    checkboxCatAddAd.toggle()
                if (addInfo.other)
                    checkboxOtherAnimalAddAd.toggle()
                if (addInfo.rodent)
                    checkboxRodentAddAd.toggle()
              //  Picasso.get().load(addInfo.imageId).into(PhotoAd)
            }
        }

        viewModel.userPhoto.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.PhotoAd.setImageBitmap(it)
            }
        }
        binding.PhotoAd.setOnClickListener {
            val photoIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(photoIntent, 1)
        }

        binding.saveButtonAd.setOnClickListener {
            with(binding){
                viewModel.editAdCompany(
                    HotelAddsModel(
                        id = itemId.toString(),
                        //imageId = "",
                        name = nameHotelEditTextAdd.text.toString(),
                        city = cityHotelEditTextAdd.text.toString(),
                        address = addressHotelEditTextAdd.text.toString(),
                        number = numberEditText.text.toString(),
                        description = hintDescribeAddAd.text.toString(),
                        cat = checkboxCatAddAd.isChecked,
                        rodent = checkboxRodentAddAd.isChecked,
                        dog = checkboxDogAddAd.isChecked,
                        other = checkboxOtherAnimalAddAd.isChecked
                    )
                )
                itemId?.let { viewModel.setHotelPhoto(selectedAvatarUri?.path, it) }


            }
             findNavController().navigate(R.id.action_viewingAdFragment_to_mainFragment)
        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.deleteButtonAd.setOnClickListener {
            viewModel.deleteAdd(itemId.toString())
            findNavController().navigate(R.id.action_viewingAdFragment_to_mainFragment)
        }

        binding.PhotoAd.setOnClickListener {
            if (isStoragePermissionGranted()) {
                requireActivity().pickImage(pickerResultLauncher, needCrop = true)
            }
        }

    }

}
