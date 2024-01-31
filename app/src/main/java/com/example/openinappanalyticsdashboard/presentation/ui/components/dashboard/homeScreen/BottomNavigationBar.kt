package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.R


@Composable
fun NavBottomBarWrapper(navController: NavController) {
    BottomAppBar(
        modifier = Modifier
            .height(59.dp)
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        cutoutShape = null,
        backgroundColor = Color.White,
        elevation = 22.dp
    ) {
        BottomNavigationBar(navController = navController)
    }
}

sealed class BottomNavItem(val route: String, val icon: Int?) {
    data object Courses : BottomNavItem(OpenInAppConstants.COURSES, R.drawable.courses_icon)
    data object Home : BottomNavItem(OpenInAppConstants.HOME, null)
    data object Profile : BottomNavItem(OpenInAppConstants.PROFILE, R.drawable.profile_icon)
    data object Campaigns : BottomNavItem(OpenInAppConstants.CAMPAIGNS, R.drawable.campaigns_icon)
    data object Links : BottomNavItem(OpenInAppConstants.LINKS, R.drawable.links_icon)
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(backgroundColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItemList = listOf(
            BottomNavItem.Links,
            BottomNavItem.Courses,
            BottomNavItem.Home,
            BottomNavItem.Campaigns,
            BottomNavItem.Profile
        )
        navigationItemList.forEach { item ->
            BottomNavigationItem(selected = currentRoute == item.route,
                selectedContentColor = Color.Blue,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    item.icon?.let { resId->
                        Icon(
                            painter = painterResource(id = resId),
                            contentDescription = item.route
                        )
                    }

                })

        }
    }
}