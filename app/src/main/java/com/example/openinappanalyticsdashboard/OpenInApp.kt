package com.example.openinappanalyticsdashboard

import android.app.Application
import com.example.openinappanalyticsdashboard.presentation.SharePreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OpenInApp: Application() {
    override fun onCreate() {
        super.onCreate()
        SharePreferenceManager.init(context = this)
    }
}