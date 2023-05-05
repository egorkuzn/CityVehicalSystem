package ru.nsu.fit.g20204.egorkuzn.client.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.MenuScreen

object AppViewDesktop {
    /**
     * Здесь задается начальное значение контроллера, который занимается навигацией.
     * Начальный экран - это меню, в котором происходит выбор таблицы.
     */
    private val currentScreen by NavController.currentScreen

    @Composable
    @Preview
    fun render() {
        MaterialTheme {
            Surface(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        currentScreen.render()
                    }
                }
            }
        }
    }
}