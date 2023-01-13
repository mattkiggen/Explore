package com.dotmatt.explore.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsPage() {
    Column(Modifier.padding(24.dp)) {
        Text(
            text = "Settings",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 48.dp)
        )
        Text("UNIT OF MEASUREMENT", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Metric")
            Switch(checked = false, onCheckedChange = {})
        }
        Divider(thickness = 1.dp, color = Color(0xFFF2F2F2), modifier = Modifier.padding(vertical = 24.dp))
        Text("PREFERRED LANDMARKS", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Historical")
            Checkbox(checked = true, onCheckedChange = { })
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Modern")
            Checkbox(checked = false, onCheckedChange = { })
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Popular")
            Checkbox(checked = false, onCheckedChange = { })
        }
    }
}