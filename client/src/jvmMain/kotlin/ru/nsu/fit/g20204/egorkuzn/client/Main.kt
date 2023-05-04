package ru.nsu.fit.g20204.egorkuzn.client

import AppViewDesktop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.nsu.fit.g20204.egorkuzn.client.controller.CityVehicleSystemApi
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import java.awt.Dimension
import java.awt.Toolkit

@ExperimentalMaterial3Api
fun main() = application {
    val apiImpl = RetrofitBuilder
        .getInstance()
        .create(CityVehicleSystemApi::class.java)

    Window(
        onCloseRequest = ::exitApplication,
        title = "CityVehicleSystem",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = getPreferredWindowSize(1000, 1000)
        ),
    ) {
        AppViewDesktop()
    }
}

fun getPreferredWindowSize(desiredWidth: Int, desiredHeight: Int): DpSize {
    val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
    val preferredWidth: Int = (screenSize.width * 0.8f).toInt()
    val preferredHeight: Int = (screenSize.height * 0.8f).toInt()
    val width: Int = if (desiredWidth < preferredWidth) desiredWidth else preferredWidth
    val height: Int = if (desiredHeight < preferredHeight) desiredHeight else preferredHeight
    return DpSize(width.dp, height.dp)
}