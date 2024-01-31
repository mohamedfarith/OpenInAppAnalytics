package com.example.openinappanalyticsdashboard.presentation.dashboard

import com.example.openinappanalyticsdashboard.data.repositoryImpl.dashboard.DashboardRepositoryImpl
import com.example.openinappanalyticsdashboard.data.useCaseImpl.DashboardUseCaseImpl
import com.example.openinappanalyticsdashboard.network.NetworkState
import com.example.openinappanalyticsdashboard.presentation.ui.viewModels.DashboardViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DashboardViewModelTest {
    private val testScheduler = TestCoroutineScheduler()
    private val testDispatcher = StandardTestDispatcher(testScheduler)
    private val testScope = TestScope(testDispatcher)

    private var datasource = FakeDashboardDataSourceImpl()
    private var repositoryImpl = DashboardRepositoryImpl(datasource = datasource)
    private var viewModel = DashboardViewModel(DashboardUseCaseImpl(repository = repositoryImpl))

    @Test
    fun `check if initial state is loading`() {
        assertEquals(true, viewModel.dashBoardData.value is NetworkState.Loading)
    }

    @Test
    fun `check for data source`() {
        testScope.launch {
            viewModel.fetchDashBoarData()
            assertEquals(true, viewModel.dashBoardData.value is NetworkState.Success)
        }

    }

}
