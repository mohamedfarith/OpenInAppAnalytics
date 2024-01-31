package com.example.openinappanalyticsdashboard.presentation.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.data.NetworkState
import com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard.DashboardRepositoryImpl
import com.example.openinappanalyticsdashboard.data.useCaseImpl.DashboardUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.cache
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(var useCase: DashboardUseCaseImpl) : ViewModel() {
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