package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(
    val label: String,
    val icon: ImageVector
) {
    MenuScreen(
        label = "Menu",
        icon = Icons.Filled.Menu
    ),
    NotificationsScreen(
        label = "Notifications",
        icon = Icons.Filled.Notifications
    ),
    SettingsScreen(
        label = "Settings",
        icon = Icons.Filled.Settings
    ),
    ProfileScreens(
        label = "User Profile",
        icon = Icons.Filled.Face
    )
}