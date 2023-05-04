package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

/**
 * Базовый класс для экрана, используемого в навигации
 */
abstract class BaseScreen {
    /**
     * Функция отрисовки экрана навигации.
     *
     * @param screenName - Принимает название экрана, на который собираемся переключиться
     * @param navController - Контроллер, который занимается навигацией
     */
    @Composable
    fun render(
        screenName: Screen,
        navController: NavController
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement =  Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!(this@BaseScreen is MenuScreen)) {
                Button(
                    onClick = {
                        navController.navigate(screenName)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Navigate to $screenName")
                }
            }
            Text(navController.currentScreen.value.label)
            content(navController)
        }
    }

    @Composable
    abstract fun content(navController: NavController)
}