package com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard

import com.example.openinappanalyticsdashboard.data.dataSourceImpl.dashboard.DashboardDataSourceImpl
import com.example.openinappanalyticsdashboard.domain.dataSources.dashboard.DashboardDataSource
import com.example.openinappanalyticsdashboard.domain.repositories.dashboard.DashboardRepository
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(val datasource: DashboardDataSource) :
    DashboardRepository {
    override suspend fun fetchDashboardData() = datasource.getDashboardData()

}