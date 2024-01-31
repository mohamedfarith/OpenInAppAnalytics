package com.example.openinappanalyticsdashboard.presentation.di

import com.example.openinappanalyticsdashboard.data.services.DashboardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class OpenInAppModule {

    @Provides
    fun getServiceInstance(): DashboardService = DashboardService.create()

}