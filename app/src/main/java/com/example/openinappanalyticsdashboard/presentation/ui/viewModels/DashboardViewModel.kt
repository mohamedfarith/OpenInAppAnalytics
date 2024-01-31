package com.example.openinappanalyticsdashboard.presentation.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappanalyticsdashboard.network.NetworkState
import com.example.openinappanalyticsdashboard.data.useCaseImpl.DashboardUseCaseImpl
import com.example.openinappanalyticsdashboard.domain.usecases.dashboard.FetchDashboardIseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(var useCase: FetchDashboardIseCase) : ViewModel() {
    private var _dashBoardData = MutableStateFlow<NetworkState>(NetworkState.Loading)
    val dashBoardData: StateFlow<NetworkState>
        get() = _dashBoardData


    fun fetchDashBoarData() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke().collect { networkState ->
                _dashBoardData.value = networkState
            }
        }


    }
}