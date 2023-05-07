package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam.DriversCarDistributionQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam.GarageEconomyInfoQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam.InfoAboutAutoparkQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param.CargoVolumeStatQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param.MileageInfoQuery

@OptIn(ExperimentalFoundationApi::class)
abstract class AbstractQueryScreen(val description: String) : AbstractScreen(description) {
    companion object {
        val listOfQueries = listOf(
            CargoVolumeStatQuery,
            DriversCarDistributionQuery,
            GarageEconomyInfoQuery,
            InfoAboutAutoparkQuery,
            MileageInfoQuery
        )
    }

    private var isLaunched by mutableStateOf(false)

    @Composable
    override fun content(navController: NavController) {
        if (!isLaunched) {
            Column {
                Button(
                    onClick = { onUpdate() },
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 0.dp)
                ) { Text("Загрузка...") }
                launchEffect { !isLaunched }
            }
        } else {
            Column {
                Button(
                    onClick = { onUpdate() },
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 0.dp)
                ) { Text("Обновить") }
                queryContent()
            }
        }
    }

    @Composable
    fun launchEffect(onAction: () -> Unit) {
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(onAction) {
            coroutineScope.launch {
                loadFunction()
                isLaunched = true
            }
        }
    }

    override fun onUpdate() {
        isLaunched = !isLaunched
    }

    abstract fun loadFunction()

    @Composable
    abstract fun queryContent()

    @Composable
    override fun render() = render(QueryViewerScreen)

    abstract fun getHead(): List<String>

    abstract fun getData(): List<List<String>>
}