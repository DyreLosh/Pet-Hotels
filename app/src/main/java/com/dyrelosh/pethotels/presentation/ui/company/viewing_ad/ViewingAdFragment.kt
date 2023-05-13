package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.URIPathHelper
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.squareup.picasso.Picasso
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File


class ViewingAdFragment : Fragment() {

    lateinit var binding: FragmentViewingAdBinding
    private val viewModel by viewModel<CompanyViewingAdViewModel>()
    private var itemId: String? = null

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
        viewModel.addInfo.observe(viewLifecycleOwner) { addInfo ->
           // viewModel.getHotelPhoto(addInfo.imageId)
            with(binding){
                nameHotelEditTextAdd.setText(addInfo.name)
                cityHotelEditTextAdd.setText(addInfo.city)
                addressHotelEditTextAdd.setText(addInfo.address)
                numberEditText.setText(addInfo.number)
                hintDescribeAddAd.setText(addInfo.description)
                if (addInfo.dog == true)
                    checkboxDogAddAd.toggle()
                if (addInfo.cat == true)
                    checkboxCatAddAd.toggle()
                if (addInfo.other == true)
                    checkboxOtherAnimalAddAd.toggle()
                if (addInfo.rodent == true)
                    checkboxRodentAddAd.toggle()
                Picasso.get().load(addInfo.imageId).into(PhotoAd)
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
                        imageId = "",
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

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            val helper = URIPathHelper()
            val path = helper.getPath(requireContext(), data.data!!)
            val file = File(path)
            val requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file)
            val part = MultipartBody.Part.createFormData("uploadedFile", file.name, requestFile)
            binding.PhotoAd.setImageURI(data.data)
            viewModel.setHotelPhoto(part)
        }
    }
}
