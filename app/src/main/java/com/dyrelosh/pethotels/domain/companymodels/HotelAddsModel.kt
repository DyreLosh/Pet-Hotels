package com.dyrelosh.pethotels.domain.companymodels

data class HotelAddsModel (
    val idAdd: String,
    val nameHotel: String,
    val cityHotel: String,
    val addressHotel: String,
    val numberHotel: String,
    val descriptionHotel: String,
  //  val photoHotel: String,
    val catCategory: Boolean,
    val rodentCategory: Boolean,
    val dogCategory: Boolean,
    val otherCategory: Boolean
)