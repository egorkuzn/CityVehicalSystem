package ru.nsu.fit.g20204.egorkuzn.client

import ru.nsu.fit.g20204.egorkuzn.client.view.AppViewDesktop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import java.awt.Dimension

class SizeWindows {
    companion object {
        fun height(): Int = 480
        fun width(): Int = 640
    }
}

@ExperimentalMaterial3Api
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CityVehicleSystem",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = SizeWindows.width().dp,
            height = SizeWindows.height().dp
        )
    ) {
        window.minimumSize = Dimension(SizeWindows.width(), SizeWindows.height())
        AppViewDesktop.render()
    }
}