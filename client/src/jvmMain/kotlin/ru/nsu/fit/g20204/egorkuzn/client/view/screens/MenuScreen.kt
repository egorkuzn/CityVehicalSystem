package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

object MenuScreen : BaseScreen() {
    @Composable
    override fun content(navController: NavController) {
        Text(navController.currentScreen.value.label)

        Button(
            onClick = {
                navController.navigate(Screen.ProfileScreens)
            }
        ) {
            Text("Navigate to ")
        }

        Button(
            onClick = {
                navController.navigate(Screen.ProfileScreens)
            }
        ) {
            Text("Navigate to ")
        }
    }
}