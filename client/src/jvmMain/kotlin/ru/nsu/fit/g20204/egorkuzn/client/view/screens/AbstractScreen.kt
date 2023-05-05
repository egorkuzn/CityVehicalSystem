package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

/**
 * Базовый класс для экрана, используемого в навигации
 */
abstract class AbstractScreen(
    val label: String,
    val icon: ImageVector
) {
    /**
     * Функция отрисовки экрана навигации.
     *
     * @param screen - Принимает название экрана, на который собираемся переключиться
     * @param navController - Контроллер, который занимается навигацией
     */
    @Composable
    fun render(
        screen: AbstractScreen,
        navController: NavController
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement =  Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!(this@AbstractScreen is MenuScreen)) {
                Button(
                    onClick = {
                        onUpdate()
                        navController.navigate(screen)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("< $screen")
                }
            }

            Text(
                text = navController
                .currentScreen
                .value
                .toString()
            )

            content(navController)
        }
    }

    override fun toString(): String {
        return label
    }

    companion object {
        val screensList = ArrayList<AbstractScreen>()
    }

    @Composable
    abstract fun render(navController: NavController)

    @Composable
    abstract fun content(navController: NavController)

    abstract fun onUpdate()
}