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
    val navController by rememberNavController(Screen.InfoAboutAutopark.name)
    val currentScreen by remember {
        navController.currentScreen
    }
HashMap
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
                                            modifier = Modifier.height((item.lines * 60).dp)
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
    val lines: Short
) {
    CargoVolumeStat(
        label = """
            Cведения о грузоперевозках, выполненных указанной
            автомашиной за обозначенный период.
        """.trimIndent(),
        lines = 2
    ),
    DriversCarDistribution(
        label = "Распределение водителей по автомобилям.",
        lines = 1
    ),
    GarageEconomyInfo(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        lines = Icons.Filled.Notifications
    ),
    InfoAboutAutopark(
        label = "Данные об автопарке предприятия.",
        lines = Icons.Filled.Home
    ),
    MileageInfo(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        lines = Icons.Filled.Notifications
    ),
    PassengersToRoutsDistr(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    RepairsStatEngineer(
        label = "Перечень и общее число водителей по предприятию, по указанной автомашине.",
        lines = Icons.Filled.Notifications
    ),
    RepairsStatNode(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    RepairsStatTransport(
        label = "Данные о распределении пассажирского автотранспорта по маршрутам.",
        lines = Icons.Filled.Face
    ),
    VehicleAddArchive(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    VehicleDriversAndCount(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    VehicleToCompanyDistr(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    WorkersHierarchyInfo(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    ),
    WorkersHirarchyInfoManager(
        label = "Распределение водителей по автомобилям.",
        lines = Icons.Filled.Settings
    )
}


@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screen.InfoAboutAutopark.name) {
            HomeScreen(navController)
        }

        composable(Screen.RepairsStatEngineer.name) {
            NotificationScreen(navController)
        }

        composable(Screen.VehicleAddArchive.name) {
            SettingScreen(navController)
        }

        composable(Screen.RepairsStatTransport.name) {
            ProfileScreen(navController)
        }

    }.build()
}