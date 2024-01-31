package com.example.openinappanalyticsdashboard.domain.dataSources.dashboard

import com.example.openinappanalyticsdashboard.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface DashboardDataSource {
    suspend fun getDashboardData(): Flow<NetworkState>
}