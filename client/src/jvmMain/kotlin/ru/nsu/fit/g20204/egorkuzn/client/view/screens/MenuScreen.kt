package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

object MenuScreen : AbstractScreen(
    label = "Меню",
    icon = Icons.Filled.Menu
) {
    init {
        screensList.add(this)
    }

    @Composable
    override fun content(navController: NavController) {
        toQueryScreenButton(navController)
        toEditorScreenButton(navController)
    }

    @Composable
    fun toQueryScreenButton(navController: NavController) = Button(
        onClick = {
            navController.navigate(QueryViewerScreen)
        }
    ) {
        Text(QueryViewerScreen.toString())
    }

    @Composable
    fun toEditorScreenButton(navController: NavController) = Button(
        onClick = {
            navController.navigate(EditingMasterScreen)
        }
    ) {
        Text(EditingMasterScreen.toString())
    }

    override fun onUpdate() {

    }
}