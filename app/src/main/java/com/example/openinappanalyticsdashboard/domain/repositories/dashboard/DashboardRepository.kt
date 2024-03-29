package com.example.openinappanalyticsdashboard.domain.repositories.dashboard

import com.example.openinappanalyticsdashboard.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    suspend fun fetchDashboardData(): Flow<NetworkState>
}