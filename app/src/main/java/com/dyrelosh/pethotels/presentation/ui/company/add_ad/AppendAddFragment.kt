package com.dyrelosh.pethotels.presentation.ui.company.add_ad

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.URIPathHelper
import com.dyrelosh.pethotels.databinding.FragmentAddAppendBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class AppendAddFragment : Fragment() {
    private val viewModel by viewModel<AppendAddViewModel>()
    lateinit var binding: FragmentAddAppendBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddAppendBinding.inflate(inflater, container, false)
       // setContentView(binding.root)
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.userPhoto.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.PhotoAddAd.setImageBitmap(it)
            }
        }
        binding.PhotoAddAd.setOnClickListener {
            val photoIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(photoIntent, 1)
        }
        binding.saveButtonAddAd.setOnClickListener {
            with(binding){
                val newAdd = HotelAppendAddModel(
                    imageId = "",
                    name = nameHotelEditTextAppendAdd.text.toString(),
                    city = cityHotelEditTextAppendAdd.text.toString(),
                    address = addressHotelEditTextAppendAdd.text.toString(),
                    number = numberHotelEditTextAppendAdd.text.toString(),
                    description = describeHotelEditTextAppendAdd.text.toString(),
                    cat = checkboxCatAppendAdd.isChecked,
                    rodent = checkboxRodentAppendAdd.isChecked,
                    dog = checkboxDogAppendAdd.isChecked,
                    other = checkboxOtherAnimalAppendAdd.isChecked
                )
                viewModel.appendAdd(newAdd)
            }

            viewModel.appendAddAction.observe(viewLifecycleOwner){
                if (it) {
                    findNavController().navigate(R.id.action_appendAddFragment_to_mainFragment)
                }
            }
        }
        return binding.root
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
            binding.PhotoAddAd.setImageURI(data.data)
            viewModel.setHotelPhoto(part)
        }
    }
}
