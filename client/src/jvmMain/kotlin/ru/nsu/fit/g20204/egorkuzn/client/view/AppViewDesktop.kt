// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavigationHost
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.rememberNavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.HomeScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.NotificationScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.ProfileScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.SettingScreen

@ExperimentalMaterial3Api
@Composable
@Preview
fun AppViewDesktop() {
    val screens = Screen.values().toList()
    val navController by rememberNavController(Screen.HomeScreen.name)
    val currentScreen by remember {
        navController.currentScreen
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Spacer(Modifier.height(6.dp))
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(screens) {
                                        item -> NavigationDrawerItem(
                                            icon = {},
                                            label = {
                                                Text(text = item.label)
                                            },
                                            selected = item.name == currentScreen,
                                            onClick = {
                                                scope.launch { drawerState.close() }
                                                navController.navigate(item.name)
                                            },
                                            modifier = Modifier.height(((item.label.length / 40 + 1) * 60).dp)
                                        )
                                }
                            }
                        }
                    },
                    content = {
                        Box(
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            CustomNavigationHost(navController = navController)
                        }
                    }
                )
            }
        }
    }
}

/**
 * Screens
 */
enum class Screen(
    val label: String,
    val icon: ImageVector
) {
    HomeScreen(
        label = "Данные об автопарке предприятия.",
        icon = Icons.Filled.Home
    ),
    NotificationsScreen3(
        label = "Перечень и общее число водителей по предприятию, по указанной а",
        icon = Icons.Filled.Notifications
    ),
    SettingsScreen3(
        label = "Распределение водителей по автомобилям.",
        icon = Icons.Filled.Settings
    ),
    NotificationsScreen4(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        icon = Icons.Filled.Notifications
    ),
    SettingsScreen4(
        label = "Распределение водителей по автомобилям.",
        icon = Icons.Filled.Settings
    ),
    NotificationsScreen2(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        icon = Icons.Filled.Notifications
    ),
    SettingsScreen2(
        label = "Распределение водителей по автомобилям.",
        icon = Icons.Filled.Settings
    ),
    NotificationsScreen(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        icon = Icons.Filled.Notifications
    ),
    SettingsScreen(
        label = "Распределение водителей по автомобилям.",
        icon = Icons.Filled.Settings
    ),
    ProfileScreens(
        label = "Данные о распределении пассажирского автотранспорта по маршрутам.",
        icon = Icons.Filled.Face
    )
}


@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screen.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(Screen.NotificationsScreen.name) {
            NotificationScreen(navController)
        }

        composable(Screen.SettingsScreen.name) {
            SettingScreen(navController)
        }

        composable(Screen.ProfileScreens.name) {
            ProfileScreen(navController)
        }

    }.build()
}