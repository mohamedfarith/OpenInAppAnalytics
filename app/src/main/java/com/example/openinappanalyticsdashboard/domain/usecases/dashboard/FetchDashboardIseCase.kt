package com.example.openinappanalyticsdashboard.domain.usecases.dashboard

import com.example.openinappanalyticsdashboard.data.NetworkState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FetchDashboardIseCase {

    suspend fun invoke(): Flow<NetworkState>
}