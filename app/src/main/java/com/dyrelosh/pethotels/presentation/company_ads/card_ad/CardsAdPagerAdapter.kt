package com.dyrelosh.pethotels.presentation.company_ads.card_ad

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dyrelosh.pethotels.presentation.company_ads.CompanyAdsFragment

class CardsAdPagerAdapter (
    fragment: Fragment,
    private val tabCount: Int
    ) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = tabCount
    override fun createFragment(position: Int): Fragment {
        return CompanyAdsFragment()
    }
}
