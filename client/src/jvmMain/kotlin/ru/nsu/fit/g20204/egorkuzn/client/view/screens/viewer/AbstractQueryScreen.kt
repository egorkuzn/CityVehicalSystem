package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam.DriversCarDistributionQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam.GarageEconomyInfoQuery
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param.CargoVolumeStatQuery

@OptIn(ExperimentalFoundationApi::class)
abstract class AbstractQueryScreen(val description: String): AbstractScreen(description) {
    companion object {
        val listOfQueries = listOf(
            CargoVolumeStatQuery,
            DriversCarDistributionQuery,
            GarageEconomyInfoQuery
        )
    }

    override fun onUpdate() {

    }

    @Composable
    override fun render() = render(QueryViewerScreen)

    abstract fun getHead(): List<String>

    abstract fun getData(): List<List<String>>
}