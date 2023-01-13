package com.dotmatt.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dotmatt.explore.Routes

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        NavItem(Icons.Rounded.Home,"Home", (currentRoute == Routes.Home.name)) {
            navController.navigate(Routes.Home.name)
        }
        NavItem(Icons.Rounded.LocationOn,"Map", (currentRoute == Routes.Map.name)) {
            navController.navigate(Routes.Map.name)
        }
        NavItem(Icons.Rounded.Settings,"Settings", (currentRoute == Routes.Settings.name)) {
            navController.navigate(Routes.Settings.name)
        }
    }
}

@Composable
fun NavItem(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
    if (isSelected) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFFF2F2F2), shape = RoundedCornerShape(50))
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clickable { onClick() }
        ) {
            Icon(icon, label, tint = Color.Black)
            Text(label, color = Color.Black, modifier = Modifier.padding(start = 8.dp))
        }
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() }
        ) {
            Icon(icon, label, tint = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    BottomNav(navController = rememberNavController())
}