package com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard

import com.example.openinappanalyticsdashboard.data.dataSourceImpl.dashboard.DashboardDataSourceImpl
import com.example.openinappanalyticsdashboard.domain.repositories.dashboard.DashboardRepository
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(private val datasource: DashboardDataSourceImpl) :
    DashboardRepository {
    override suspend fun fetchDashboardData() = datasource.getDashboardData()

}