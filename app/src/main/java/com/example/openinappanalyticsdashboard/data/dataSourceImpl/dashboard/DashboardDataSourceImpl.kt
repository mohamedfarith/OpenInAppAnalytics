package com.example.openinappanalyticsdashboard.data.dataSourceImpl.dashboard

import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.network.DataWrapper
import com.example.openinappanalyticsdashboard.network.NetworkState
import com.example.openinappanalyticsdashboard.network.services.DashboardService
import com.example.openinappanalyticsdashboard.domain.dataSources.dashboard.DashboardDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashboardDataSourceImpl @Inject constructor(private val service: DashboardService) :
    DashboardDataSource {
    override suspend fun getDashboardData(): Flow<NetworkState> =
        flow {
            emit(DataWrapper.invoke(service.getDashboardData()))
        }.catch {
            emit(NetworkState.Failure(message = OpenInAppConstants.DEFAULT_API_FAILURE_MESSAGE))
        }

}