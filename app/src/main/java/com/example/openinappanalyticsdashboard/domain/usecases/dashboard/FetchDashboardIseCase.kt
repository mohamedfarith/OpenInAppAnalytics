package com.example.openinappanalyticsdashboard.domain.usecases.dashboard

import com.example.openinappanalyticsdashboard.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface FetchDashboardIseCase {

    suspend fun invoke(): Flow<NetworkState>
}