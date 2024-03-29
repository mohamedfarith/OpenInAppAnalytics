package com.example.openinappanalyticsdashboard.presentation.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.openinappanalyticsdashboard.data.dataSourceImpl.dashboard.DashboardDataSourceImpl
import com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard.DashboardRepositoryImpl
import com.example.openinappanalyticsdashboard.data.useCaseImpl.DashboardUseCaseImpl
import com.example.openinappanalyticsdashboard.domain.dataSources.dashboard.DashboardDataSource
import com.example.openinappanalyticsdashboard.domain.repositories.dashboard.DashboardRepository
import com.example.openinappanalyticsdashboard.domain.usecases.dashboard.FetchDashboardIseCase
import com.example.openinappanalyticsdashboard.network.services.DashboardService
import com.example.openinappanalyticsdashboard.presentation.PreferenceConstants
import com.example.openinappanalyticsdashboard.presentation.SharePreferenceManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class OpenInAppModule {

    @Provides
    fun getServiceInstance(): DashboardService {
        val token = SharePreferenceManager.getString(PreferenceConstants.TOKEN) ?: ""
        return DashboardService.create(token)
    }
}