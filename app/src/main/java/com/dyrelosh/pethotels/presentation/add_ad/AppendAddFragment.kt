package com.dyrelosh.pethotels.presentation.add_ad

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentAddAppendBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAppendAddModel
import com.dyrelosh.pethotels.presentation.main.CompanyMainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AppendAddFragment : Fragment() {
    private val viewModel by viewModel<AppendAddViewModel>()
    lateinit var binding: FragmentAddAppendBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAppendBinding.inflate(inflater, container, false)
       // setContentView(binding.root)
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.saveButtonAddAd.setOnClickListener {
            with(binding){
//
//                        nameHotelLayoutAppendAdd.isNotEmpty() &&
//                        numberHotelLayoutAppendAdd.isNotEmpty() &&
//                        describeHotelLayoutAppendAdd.isNotEmpty()

                val newAdd = HotelAppendAddModel(
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

}