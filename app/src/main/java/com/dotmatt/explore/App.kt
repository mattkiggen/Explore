package com.dotmatt.explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dotmatt.explore.components.BottomNav
import com.dotmatt.explore.pages.HomePage
import com.dotmatt.explore.pages.MapPage
import com.dotmatt.explore.pages.SettingsPage

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { Text("Explore") },
        bottomBar = { BottomNav(navController) }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(navController = navController, startDestination = Routes.Home.name) {
                composable(Routes.Home.name) { HomePage() }
                composable(Routes.Map.name) { MapPage() }
                composable(Routes.Settings.name) { SettingsPage() }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}