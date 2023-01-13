package com.dotmatt.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.dotmatt.explore.Routes

@Composable
fun BottomNav(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth().background(Color.Gray)) {
        Text("Home", Modifier.clickable { navController.navigate(Routes.Home.name) })
        Text("Map", Modifier.clickable { navController.navigate(Routes.Map.name) })
        Text("Settings", Modifier.clickable { navController.navigate(Routes.Settings.name) })
    }
}