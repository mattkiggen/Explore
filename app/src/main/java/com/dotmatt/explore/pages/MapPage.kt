package com.dotmatt.explore.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapPage() {
    val permissionState = rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)
    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(LocalContext.current)
    val (currentLocation, setCurrentLocation) = remember { mutableStateOf(LatLng(-33.918861, 18.423300)) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
    }

    if (permissionState.hasPermission) {
        fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, null).addOnSuccessListener {
            setCurrentLocation(LatLng(it.latitude, it.longitude))
            cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Circle(center = currentLocation, fillColor = Color.Blue, radius = 10.0)
        }
    } else {
        Button(onClick = { permissionState.launchPermissionRequest() }) {
            Text(text = "Enable permissions")
        }
    }
}