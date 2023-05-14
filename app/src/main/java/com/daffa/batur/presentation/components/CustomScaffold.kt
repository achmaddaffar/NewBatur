package com.daffa.batur.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.data.models.BottomNavItem
import com.daffa.batur.presentation.util.Screen

@Composable
fun CustomScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    showToolbar: Boolean = true,
    toolbarTitle: String? = null,
    showBackArrow: Boolean = true,
    navActions: @Composable RowScope.() -> Unit = {},
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.GameMapScreen.route,
            icon = painterResource(id = R.drawable.map_icon),
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = painterResource(id = R.drawable.home_icon),
            contentDescription = "Activity"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = painterResource(id = R.drawable.profile_icon),
            contentDescription = "Profile"
        )
    ),
    onFabClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar)
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = MaterialTheme.shapes.large,
                    elevation = 5.dp
                ) {
                    BottomNavigation(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        bottomNavItems.forEachIndexed { index, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.popBackStack()
                                    navController.navigate(bottomNavItems[index].route)
                                }
                            }
                        }
                    }
                }
        },
        modifier = modifier
    ) {
        content(it)
    }
}