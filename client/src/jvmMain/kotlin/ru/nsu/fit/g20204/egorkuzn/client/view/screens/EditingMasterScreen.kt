package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

object EditingMasterScreen: AbstractScreen(
    "Редактирование данных",
    Icons.Filled.Add
) {
    init {
        screensList.add(this)
    }

    val head = mutableStateOf(ArrayList<String>())
    val tableData = mutableStateOf(ArrayList<ArrayList<String>>())

    @Composable
    override fun content(navController: NavController) {
        TableScreen(head.value, tableData.value)
    }

    override fun onUpdate() {

    }
}

