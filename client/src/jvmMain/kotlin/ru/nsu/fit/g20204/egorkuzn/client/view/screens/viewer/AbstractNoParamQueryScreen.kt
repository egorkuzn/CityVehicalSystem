package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.Composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

abstract class AbstractNoParamQueryScreen(description: String): AbstractQueryScreen(description) {
    @Composable
    override fun content(navController: NavController) {
        Table(getHead(), getData())
    }

    override fun onUpdate() {

    }

    @Composable
    override fun render() = render(QueryViewerScreen)
}