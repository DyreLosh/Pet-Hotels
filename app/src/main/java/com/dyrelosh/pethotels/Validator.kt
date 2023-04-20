package com.dyrelosh.pethotels

import android.text.Editable

class Validator {
    companion object {
        private const val INN_LENGTH = 12
        private const val PASS_LENGTH = 6
    }

    fun validateNameHotel(text: Editable?): String? =
        if (text?.isEmpty() == false ) {
            null
        } else {
            "Error Name Hotel"
        }

    fun validateINNHotel(text: Editable?): String? =
        if (text?.isEmpty() == false && text.length == INN_LENGTH) {
            null
        } else {
            "Error INN"
        }

    fun validateEmailHotel(text: Editable?): String? =
        if (text?.isEmpty() == false && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()
        ) {
            null
        } else {
            "Error email"
        }

    fun validatePasswordHotel(text: Editable?): String? =
        if (text?.isEmpty() == false && text.length >= PASS_LENGTH) {
            null
        } else {
            "Error password"
        }

    fun returnPasswordHotel(retPass: Editable?, pass: Editable?): String? =
        if (validatePasswordHotel(retPass) == null &&
            validatePasswordHotel(pass) == null &&
            retPass.toString() == pass.toString()
        ) {
            null
        } else {
            "Error confirm password"
        }

    /*fun validateAdd(text: Editable?): String? =
        if (text?.isEmpty() == false) {
            null
        } else {
            "Is empty"
        }*/
}