package com.example.openinappanalyticsdashboard.presentation.di

import com.example.openinappanalyticsdashboard.data.dataSourceImpl.dashboard.DashboardDataSourceImpl
import com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard.DashboardRepositoryImpl
import com.example.openinappanalyticsdashboard.data.useCaseImpl.DashboardUseCaseImpl
import com.example.openinappanalyticsdashboard.domain.dataSources.dashboard.DashboardDataSource
import com.example.openinappanalyticsdashboard.domain.repositories.dashboard.DashboardRepository
import com.example.openinappanalyticsdashboard.domain.usecases.dashboard.FetchDashboardIseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DashboardModule {
    @Binds
    abstract fun dashBoardUseCase(useCase: DashboardUseCaseImpl): FetchDashboardIseCase

    @Binds
    abstract fun dashBoardRepositoryInstance(dataSource: DashboardRepositoryImpl): DashboardRepository

    @Binds
    abstract fun dashBoardDataSourceImpl(dashboardService: DashboardDataSourceImpl): DashboardDataSource
}