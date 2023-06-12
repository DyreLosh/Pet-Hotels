package com.dyrelosh.pethotels.presentation.ui.company.add_ad

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import coil.load
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.common.URIPathHelper
import com.dyrelosh.pethotels.common.Validator
import com.dyrelosh.pethotels.databinding.FragmentAddAppendBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.extensions.handleImagePickerResult
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class AppendAddFragment : Fragment() {
    private val viewModel by viewModel<AppendAddViewModel>()
    lateinit var binding: FragmentAddAppendBinding
    private val validator = Validator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddAppendBinding.inflate(inflater, container, false)
        // setContentView(binding.root)
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.saveButtonAddAd.setOnClickListener {
            with(binding) {
                nameHotelLayoutAppendAdd.error =
                    validator.validateAdd(nameHotelEditTextAppendAdd.text)
                cityHotelLayoutAppendAdd.error =
                    validator.validateAdd(cityHotelEditTextAppendAdd.text)
                addressHotelLayoutAppendAdd.error =
                    validator.validateAdd(addressHotelEditTextAppendAdd.text)
                numberHotelLayoutAppendAdd.error =
                    validator.validateAdd(numberHotelEditTextAppendAdd.text)
                describeHotelLayoutAppendAdd.error =
                    validator.validateAdd(describeHotelEditTextAppendAdd.text)
                if( nameHotelLayoutAppendAdd.error == null &&
                    cityHotelLayoutAppendAdd.error == null &&
                    addressHotelLayoutAppendAdd.error == null &&
                    numberHotelLayoutAppendAdd.error == null &&
                    describeHotelLayoutAppendAdd.error == null) {
                    viewModel.appendAdd(
                        HotelAppendAddModel(
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
                    )
                    findNavController().navigate(R.id.action_appendAddFragment_to_mainFragment)
                }

            }
        }
        return binding.root
    }

}
