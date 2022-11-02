package com.dyrelosh.pethotels.data.api.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceStorage (context: Context) {
    companion object {
        const val SHARED_APP = "key"
        const val SHARED_TOKEN_KEY = "token"
        const val SHARED_EMAIL_KEY = "email"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_APP, Context.MODE_PRIVATE)

    var accessToken: String?
        get() = preferences.getString(SHARED_TOKEN_KEY, "")
        set(value) = preferences.edit().putString(SHARED_TOKEN_KEY, value).apply()

    var email: String?
        get() = preferences.getString(SHARED_EMAIL_KEY, "")
        set(value) = preferences.edit().putString(SHARED_EMAIL_KEY, value).apply()

    fun clearPreference() {
        preferences.edit()?.clear()?.apply()
    }
}