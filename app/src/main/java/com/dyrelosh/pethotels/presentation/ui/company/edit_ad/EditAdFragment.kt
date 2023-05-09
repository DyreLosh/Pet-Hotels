package com.dyrelosh.pethotels.presentation.ui.company.edit_ad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentEditAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.dyrelosh.pethotels.presentation.ui.company.viewing_ad.ViewingAdFragment
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.getScopeId

class EditAdFragment : Fragment() {

    lateinit var binding: FragmentEditAdBinding
    private val viewModel by viewModel<EditAdViewModel>()
    private var itemId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // itemId = arguments?.getString(ViewingAdFragment.ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditAdBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemId?.let { viewModel.getAddInfo(it) }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.adInfo.observe(viewLifecycleOwner) { adInfo ->
            with(binding){
                nameHotelEditTextAdd.setText(adInfo.name)
                cityHotelEditTextAdd.setText(adInfo.city)
                addressHotelEditTextAdd.setText(adInfo.address)
                numberEditText.setText(adInfo.number)
                hintDescribeAddAd.setText(adInfo.description)
                if(adInfo.dog == true)
                checkboxRodentAddAd.isChecked
                checkboxCatAddAd.isChecked
                checkboxDogAddAd.isChecked
                checkboxOtherAnimalAddAd.isChecked
            }
        }

        binding.saveButtonAd.setOnClickListener {
            with(binding){
                viewModel.editAdCompany(
                    HotelAddsModel(
                        id = itemId.toString(),
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

        }

    }

}