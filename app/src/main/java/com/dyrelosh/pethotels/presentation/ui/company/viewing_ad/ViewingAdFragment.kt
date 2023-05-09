package com.dyrelosh.pethotels.presentation.ui.company.viewing_ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentViewingAdBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


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

        viewModel.addInfo.observe(viewLifecycleOwner) { addInfo ->
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

            }
        }

        binding.saveButtonAd.setOnClickListener {
            with(binding){
                viewModel.editAdCompany(
                    HotelAddsModel(
                        id = it.id.toString(),
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
                findNavController().popBackStack()
            }

        }

//        binding.editAdCompanyCard.setOnClickListener {
//            findNavController().navigate(R.id.action_viewingAdFragment_to_editAdFragment)
//        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
//    companion object {
//        const val REQ_KEY = "ViewingAdFragment"
//        const val ID_KEY = "EditAdFragment"
//    }
}
