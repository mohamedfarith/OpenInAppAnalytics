package com.example.openinappanalyticsdashboard.domain.dataSources.dashboard

import com.example.openinappanalyticsdashboard.data.NetworkState
import kotlinx.coroutines.flow.Flow

interface DashboardDataSource {
    suspend fun getDashboardData(): Flow<NetworkState>
}