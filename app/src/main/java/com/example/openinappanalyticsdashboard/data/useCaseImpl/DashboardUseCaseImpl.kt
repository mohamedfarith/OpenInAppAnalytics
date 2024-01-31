package com.example.openinappanalyticsdashboard.data.useCaseImpl

import com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard.DashboardRepositoryImpl
import com.example.openinappanalyticsdashboard.domain.usecases.dashboard.FetchDashboardIseCase
import javax.inject.Inject

class DashboardUseCaseImpl @Inject constructor(val repository: DashboardRepositoryImpl) :
    FetchDashboardIseCase {
    override suspend fun invoke() = repository.fetchDashboardData()

}