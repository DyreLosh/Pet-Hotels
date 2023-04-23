package com.dyrelosh.pethotels.adapter.company

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dyrelosh.pethotels.presentation.ui.company.company_ads.CompanyAdsFragment

class CardsAdPagerAdapter (
    fragment: Fragment,
    private val tabCount: Int
    ) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = tabCount
    override fun createFragment(position: Int): Fragment {
        return CompanyAdsFragment()
    }
}
