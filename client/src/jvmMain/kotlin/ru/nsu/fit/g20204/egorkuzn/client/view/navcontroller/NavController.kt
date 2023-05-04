package ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.Screen

/**
 * Класс навигации
 */
class NavController(
    private val startDestination: Screen,
    private var backStackScreens: MutableSet<Screen> = mutableSetOf()
) {
    /**
     * Переменная, хранящая состояние текущего экрана
     */
    var currentScreen = mutableStateOf(startDestination)

    /**
     * Функция, реализующая перемещение к заданному экрану
     */
    fun navigate(route: Screen) {
        if (route != currentScreen.value) {
            if (backStackScreens.contains(currentScreen.value) &&
                currentScreen.value != startDestination) {
                backStackScreens.remove(currentScreen.value)
            }

            if (route == startDestination) {
                backStackScreens = mutableSetOf()
            } else {
                backStackScreens.add(currentScreen.value)
            }

            currentScreen.value = route
        }
    }

    /**
     * Функция возвращения на предыдущий экран
     */
    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            currentScreen.value = backStackScreens.last()
            backStackScreens.remove(currentScreen.value)
        }
    }
}


/**
 * Composable to remember the state of the navcontroller
 */
@Composable
fun rememberNavController(
    startDestination: Screen,
    backStackScreens: MutableSet<Screen> = mutableSetOf()
): MutableState<NavController> = rememberSaveable {
    mutableStateOf(NavController(startDestination, backStackScreens))
}
