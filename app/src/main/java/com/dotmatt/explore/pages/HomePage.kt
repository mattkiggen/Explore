package com.dotmatt.explore.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePage() {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text(text = "List of favourite landmarks here")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage()
}