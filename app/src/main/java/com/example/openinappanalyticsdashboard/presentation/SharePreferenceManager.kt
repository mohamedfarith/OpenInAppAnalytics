package com.example.openinappanalyticsdashboard.presentation

import android.content.Context
import android.content.SharedPreferences
import com.example.openinappanalyticsdashboard.OpenInAppConstants

object SharePreferenceManager {
    private lateinit var sharedPref: SharedPreferences
    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("OpenInApp", Context.MODE_PRIVATE)
        putString(key = PreferenceConstants.TOKEN, OpenInAppConstants.AUTH_TOKEN)
    }

    private fun isPreferenceInitialized() = ::sharedPref.isInitialized


    fun putString(key: String, value: String) {
        if (isPreferenceInitialized())
            with(sharedPref.edit()) {
                putString(key, value)
                apply()
            }
    }

    fun getString(key: String): String? {
        return if (isPreferenceInitialized())
            sharedPref.getString(key, "")
        else null
    }
}

object PreferenceConstants {
    const val TOKEN = "TOKEN"

}