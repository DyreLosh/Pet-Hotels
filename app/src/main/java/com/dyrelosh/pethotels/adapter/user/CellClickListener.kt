package com.dyrelosh.pethotels.adapter.user

import com.dyrelosh.pethotels.domain.companymodels.Hotel

interface CellClickListener {
    fun onCellClickListener(data: Hotel)
}