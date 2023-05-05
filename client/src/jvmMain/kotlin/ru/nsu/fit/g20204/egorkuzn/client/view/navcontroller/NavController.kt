package ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller

import androidx.compose.runtime.mutableStateOf
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.MenuScreen

/**
 * Класс навигации
 */
object NavController {
    private val startDestination: AbstractScreen = MenuScreen
    private var backStackScreens: MutableSet<AbstractScreen> = mutableSetOf()

    /**
     * Переменная, хранящая состояние текущего экрана
     */
    var currentScreen = mutableStateOf(startDestination)

    /**
     * Функция, реализующая перемещение к заданному экрану
     */
    fun navigate(route: AbstractScreen) {
        if (route::class != currentScreen::class) {
            if (backStackScreens.contains(currentScreen.value) &&
                currentScreen.value != startDestination
            ) {
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