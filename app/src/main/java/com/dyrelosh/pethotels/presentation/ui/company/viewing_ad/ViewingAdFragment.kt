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
                titleViewingAd.text = addInfo.name
                citiTextViewViewingAd.text = addInfo.city
                addressTextViewViewingAd.text = addInfo.address
                descriptionTextViewViewingAd.text = addInfo.description
                numberTextViewViewingAd.text = addInfo.number
                Picasso.get().load("https://st.cherinfo.ru/pages/2019/06/21/luntik-32.png")
                        // TODO нужно добавить плейсхолдер, на то время пока загружается картинка
                   // .placeholder(R.drawable.hotel_placeholder)
                    .into(photoViewingAd)
            }
        }

        binding.editAdCompanyCard.setOnClickListener {
            findNavController().navigate(R.id.action_viewingAdFragment_to_editAdFragment, bundleOf( ID_KEY to it ))
        }

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    companion object {
        const val REQ_KEY = "ViewingAdFragment"
        const val ID_KEY = "EditAdFragment"
    }
}
