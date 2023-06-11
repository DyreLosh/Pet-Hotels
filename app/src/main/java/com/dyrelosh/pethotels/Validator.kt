package com.dyrelosh.pethotels

import android.text.Editable

class Validator {
    companion object {
        private const val INN_LENGTH = 12
        private const val PASS_LENGTH = 10
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

    fun validateUserName(text: Editable?): String? =
        if (text?.isEmpty() == false && text.length > 3) {
            null
        } else {
            "Error UserName"
        }

    fun validateUserPassword(text: Editable?): String? =
        when {
            text?.isEmpty() == true -> "Поле не должно быть пустым"
            text?.length!! <= PASS_LENGTH -> "Пароль должен быть больше 10 букв"
            !text.contains("[0-9]".toRegex()) -> "Должна быть хоть одна цифра"
            else -> null
        }
    fun validateUserUserName(text: Editable?): String? =
        when {
            text?.isEmpty() == true -> "Поле не должно быть пустым"
            else -> null
        }
    fun validateUserEmail(text: Editable?): String? =
        when {
            text?.isEmpty() == true -> "Поле не должно быть пустым"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches() -> "Неправильный формать почты"
            else -> null
        }
    fun returnUserPassword(retPass: Editable?, pass: Editable?): String? =
        when {
            retPass?.isEmpty() == true -> "Поле не должно быть пустым"
            retPass?.length!! <= PASS_LENGTH -> "Пароль должен быть больше 10 букв"
            !retPass.contains("[0-9]".toRegex()) -> "Должна быть хоть одна цифра"
            retPass.toString() != pass.toString() -> "Пароли должны совпадать"
            else -> null
        }
}
