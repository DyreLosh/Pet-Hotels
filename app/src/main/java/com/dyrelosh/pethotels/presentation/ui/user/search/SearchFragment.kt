package com.dyrelosh.pethotels.presentation.ui.user.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.adapter.user.CellClickListener
import com.dyrelosh.pethotels.adapter.user.HotelAdapter
import com.dyrelosh.pethotels.databinding.FragmentSearchBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class SearchFragment : UserBaseFragment(), CellClickListener {
    lateinit var binding: FragmentSearchBinding
    lateinit var recyclerView: RecyclerView
    lateinit var searchView: SearchView
    private var list = mutableListOf<Hotel>()
    private lateinit var adapter: HotelAdapter
    override val showBottomNavigationView = true
    private val viewModel by viewModel<SearchViewModel>()
    private val recyclerAdapter by lazy { HotelAdapter(this) }
    lateinit var filteredList: MutableList<Hotel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHotels()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        recyclerView = binding.searchRecycler
        searchView = binding.searchView
        recyclerView.setHasFixedSize(true)
        adapter = HotelAdapter(this)
        recyclerView.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner) { response ->
            list.addAll(response)
        }

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(requireContext(), newText, Toast.LENGTH_SHORT).show()
                if (newText != null) {
                    filteredList = mutableListOf<Hotel>()
                    filteredList.clear()
                    for (i in list) {
                        if (newText.length >= 3) {
                            if (i.name.toLowerCase(Locale.ROOT).contains(newText)) {
                                binding.searchRecycler.visibility = View.VISIBLE
                                binding.invisibleLayout.visibility = View.INVISIBLE
                                filteredList.clear()
                                filteredList.add(i)
                                adapter.submitList(filteredList)
                            }
                        }
                        else {
                            binding.searchRecycler.visibility = View.INVISIBLE
                            binding.invisibleLayout.visibility = View.VISIBLE
                        }
                    }
                    if (filteredList.isEmpty()) {
                        filteredList.clear()
                    } else {
                        adapter.submitList(filteredList)
                    }
                }
                return true
            }
        })
        recyclerAdapter.onItemClick = { it ->

        }
        return binding.root
    }

    override fun onCellClickListener(data: Hotel) {
        OpenCardFragment.newInstance(data.advertisementId)
        findNavController().navigate(
            R.id.action_searchFragment_to_openCardFragment,
            bundleOf("OOO" to data.advertisementId)
        )
    }
}