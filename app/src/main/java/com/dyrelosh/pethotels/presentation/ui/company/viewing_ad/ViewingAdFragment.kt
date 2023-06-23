package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration.get
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.Validator
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.extensions.handleImagePickerResult
import com.dyrelosh.pethotels.extensions.isStoragePermissionGranted
import com.dyrelosh.pethotels.extensions.pickImage
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewingAdFragment : Fragment() {

    lateinit var binding: FragmentViewingAdBinding
    private val viewModel by viewModel<CompanyViewingAdViewModel>()
    private var itemId: String? = null
    private var photoID = ""
    private val validator = Validator()

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
            addInfo.photos.firstOrNull()?.let { viewModel.getHotelPhoto(it) }
            photoID = addInfo.photos.firstOrNull().toString()
            with(binding){
                nameHotelEditTextAdd.setText(addInfo.name)
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
                Picasso.with(context)
                    .load(addInfo.photos.firstOrNull())
                    .placeholder(R.drawable.ic_app_logo)
                    .into(PhotoAd)
            }
        }

        binding.saveButtonAd.setOnClickListener {
            with(binding) {
                nameHotelLayoutAdd.error =
                    validator.validateAdd(nameHotelEditTextAdd.text)
                cityHotelLayoutAdd.error =
                    validator.validateAdd(cityHotelEditTextAdd.text)
                addressHotelLayoutAdd.error =
                    validator.validateAdd(addressHotelEditTextAdd.text)
                numberLayout.error =
                    validator.validateAdd(numberEditText.text)
                hintDescribeHotelAddAd.error =
                    validator.validateAdd(hintDescribeAddAd.text)
                if (nameHotelLayoutAdd.error == null &&
                    cityHotelLayoutAdd.error == null &&
                    addressHotelLayoutAdd.error == null &&
                    numberLayout.error == null &&
                    hintDescribeHotelAddAd.error == null
                ) {
                    viewModel.editAdCompany(
                        HotelAddsModel(
                            advertisementId = itemId.toString(),
                            name = nameHotelEditTextAdd.text.toString(),
                            city = cityHotelEditTextAdd.text.toString(),
                            address = addressHotelEditTextAdd.text.toString(),
                            number = numberEditText.text.toString(),
                            description = hintDescribeAddAd.text.toString(),
                            cat = checkboxCatAddAd.isChecked,
                            rodent = checkboxRodentAddAd.isChecked,
                            dog = checkboxDogAddAd.isChecked,
                            other = checkboxOtherAnimalAddAd.isChecked
                        ), itemId.toString()
                    )
                    findNavController().navigate(R.id.action_viewingAdFragment_to_mainFragment)
                }
                itemId?.let { viewModel.setHotelPhoto(selectedAvatarUri?.path, it) }
            }
        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.deleteButtonAd.setOnClickListener {

            val builder = AlertDialog.Builder(requireContext())
            //set message for alert dialog
            builder.setMessage("Уверены, что хотите удалить объявление?")
            //builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Да"){dialogInterface, which ->
                viewModel.deleteAdd(itemId.toString())
                findNavController().navigate(R.id.action_viewingAdFragment_to_mainFragment)
                Toast.makeText(context,"Объявление удалено",Toast.LENGTH_LONG).show()
            }

            //performing negative action
            builder.setNegativeButton("Нет"){dialogInterface, which ->
                Toast.makeText(context,"Объявление не удалено",Toast.LENGTH_LONG).show()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

           // viewModel.deleteAdd(itemId.toString())
            //findNavController().navigate(R.id.action_viewingAdFragment_to_mainFragment)
        }

        binding.PhotoAd.setOnClickListener {
            if (isStoragePermissionGranted()) {
                requireActivity().pickImage(pickerResultLauncher, needCrop = true)
            }
        }

    }

}
