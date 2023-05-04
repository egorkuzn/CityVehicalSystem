import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavigationHost
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.rememberNavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.*

object AppViewDesktop {
    @Composable
    @Preview
    fun render() {
        /**
         * Имеются некоторые экраны, между которыми мы переключаемся
         */
        val screens = Screen.values().toList()

        /**
         * Здесь задается начальное значение контроллера, который занимается навигацией.
         * Начальный экран - это меню, в котором происходит выбор таблицы.
         */
        val navController by rememberNavController(Screen.MenuScreen)
        val currentScreen by remember {
            navController.currentScreen
        }

        MaterialTheme {
            Surface(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavigationRail(
                        modifier = Modifier.align(Alignment.CenterStart).fillMaxHeight()
                    ) {
                        screens.forEach {
                            NavigationRailItem(
                                selected = currentScreen == it,
                                icon = {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = it.label
                                    )
                                },
                                label = {
                                    Text(it.label)
                                },
                                alwaysShowLabel = false,
                                onClick = {
                                    navController.navigate(it)
                                }
                            )
                        }
                    }

                    Box(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        CustomNavigationHost(navController = navController)
                    }
                }
            }
        }
    }


    /**
     * Screens
     */


    @Composable
    fun CustomNavigationHost(
        navController: NavController
    ) {
        NavigationHost(navController) {
            composable(Screen.MenuScreen) {
                MenuScreen.render(Screen.ProfileScreens, navController)
            }

            composable(Screen.NotificationsScreen) {
                NotificationScreen(navController)
            }

            composable(Screen.SettingsScreen) {
                SettingScreen(navController)
            }

            composable(Screen.ProfileScreens) {
                ProfileScreen(navController)
            }

        }.build()
    }
}