package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.openinappanalyticsdashboard.R
import com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen.BottomNavItem
import com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen.DashHomeScreen
import com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen.NavBottomBarWrapper
import com.example.openinappanalyticsdashboard.presentation.ui.viewModels.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DashboardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.DarkBlue)
        setContent {
            val navController = rememberNavController()
            androidx.compose.material.Scaffold(
                bottomBar = {
                    NavBottomBarWrapper(navController = navController)
                },
                floatingActionButton = {
                    Image(painter = painterResource(id = R.drawable.add_fab_icon), "Fab")
                },
                floatingActionButtonPosition = androidx.compose.material.FabPosition.Center,
                isFloatingActionButtonDocked = true,
                contentColor = White,
                content = { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.Home.route
                    ) {
                        composable(BottomNavItem.Links.route) {
                            BackHandler {
                                navController.navigate(BottomNavItem.Home.route)
                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Hello world",color = Black)
                            }
                        }
                        composable(BottomNavItem.Courses.route) {
                            BackHandler {
                                navController.navigate(BottomNavItem.Home.route)
                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Hello world",color = Black)
                            }
                        }
                        composable(BottomNavItem.Home.route) {
                            BackHandler {
                               finish()
                            }
                            DashHomeScreen(viewModel = viewModel)
                        }
                        composable(BottomNavItem.Campaigns.route) {
                            BackHandler {
                                navController.navigate(BottomNavItem.Home.route)
                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Hello world",color = Black)
                            }
                        }
                        composable(BottomNavItem.Profile.route) {
                            BackHandler {
                                navController.navigate(BottomNavItem.Home.route)
                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Hello world",color = Black)
                            }
                        }

                    }
                }
            )


        }
    }
}