package com.dyrelosh.pethotels.adapter.user

import com.dyrelosh.pethotels.domain.models.UserHotelModel

interface CellClickListener {
    fun onCellClickListener(data: UserHotelModel)
}