package com.dyrelosh.pethotels.adapter.user

import androidx.recyclerview.widget.DiffUtil
import com.dyrelosh.pethotels.domain.companymodels.Hotel

class MyDiffUtil(
    private val oldList: MutableList<Hotel>,
    private val newList: MutableList<Hotel>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].advertisementId == newList[newItemPosition].advertisementId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =

        oldList[oldItemPosition] == newList[newItemPosition]

}