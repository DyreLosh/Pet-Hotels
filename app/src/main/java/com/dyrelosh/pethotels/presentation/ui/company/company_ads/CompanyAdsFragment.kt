package com.dyrelosh.pethotels.presentation.ui.company.company_ads

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentCompanyAdsBinding
import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.adapter.company.CardsAdsAdapter
 import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyAdsFragment : Fragment() {

    lateinit var binding: FragmentCompanyAdsBinding
    private val listAdd = mutableListOf<HotelAddsModel>()
    private val viewModel by viewModel<CompanyAdsViewModel>()
    private val cardAdapter by lazy { CardsAdsAdapter()  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompanyAdsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCardAd.adapter = cardAdapter

        viewModel.getAdds()

        viewModel.responseAdds.observe(viewLifecycleOwner) { response ->
            if (response.size != 0) {
                with(binding) {
                    progressBar.visibility= View.INVISIBLE
                    imageCompanyAdsEmpty.visibility = View.INVISIBLE
                    titleTextviewCompanyAdsEmpty.visibility = View.INVISIBLE
                    cardAdapter.submitList(response)
                    recyclerViewCardAd.visibility = View.VISIBLE
                }
            } else {
                with(binding) {
                    progressBar.visibility= View.INVISIBLE
                    titleTextviewCompanyAdsEmpty.visibility = View.VISIBLE
                    imageCompanyAdsEmpty.visibility = View.VISIBLE
                }
            }
        }

        binding.newAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_appendAddFragment)
        }
        cardAdapter.itemClick = {
             findNavController().navigate(
                 R.id.action_mainFragment_to_viewingAdFragment,
                 bundleOf( PAIR_KEY to it )
             )
        }
    }

    companion object {
        const val REQUEST_KEY = "CompanyAdsFragment"
        const val PAIR_KEY = "ViewingAdFragment"
    }
}