package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

object EditingMasterScreen: AbstractScreen(
    "Редактирование данных"
) {
    init {
        screensList.add(this)
    }

    private val head: List<String> by mutableStateOf(emptyList())
    private val tableData: List<List<String>> by mutableStateOf(emptyList())

    @Composable
    override fun render() = render(MenuScreen)

    @Composable
    override fun content(navController: NavController) {
        TableScreen(head, tableData)
    }

    override fun onUpdate() {

    }
}

