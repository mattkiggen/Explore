package com.dotmatt.explore

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dotmatt.explore.components.BottomNav
import com.dotmatt.explore.pages.HomePage
import com.dotmatt.explore.pages.MapPage
import com.dotmatt.explore.pages.SettingsPage

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { Text("Explore") },
        bottomBar = { BottomNav(navController) }
    ) {
        NavHost(navController = navController, startDestination = Routes.Home.name) {
            composable(Routes.Home.name) { HomePage() }
            composable(Routes.Map.name) { MapPage() }
            composable(Routes.Settings.name) { SettingsPage() }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}