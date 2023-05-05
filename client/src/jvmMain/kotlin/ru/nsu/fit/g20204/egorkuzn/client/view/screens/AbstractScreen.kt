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
abstract class AbstractScreen(
    val label: String
) {
    /**
     * Функция отрисовки экрана навигации.
     *
     * @param screen - Принимает название экрана, на который собираемся переключиться
     */
    @Composable
    fun render(
        screen: AbstractScreen
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (this@AbstractScreen !== MenuScreen) {
                Button(
                    onClick = {
                        onUpdate()
                        NavController.navigate(screen)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("< $screen")
                }
            }

            Text(
                text = NavController
                    .currentScreen
                    .value
                    .toString()
            )

            content(NavController)
        }
    }

    override fun toString(): String {
        return label
    }

    companion object {
        val screensList = ArrayList<AbstractScreen>()
    }

    @Composable
    abstract fun render()

    @Composable
    abstract fun content(navController: NavController)

    abstract fun onUpdate()
}