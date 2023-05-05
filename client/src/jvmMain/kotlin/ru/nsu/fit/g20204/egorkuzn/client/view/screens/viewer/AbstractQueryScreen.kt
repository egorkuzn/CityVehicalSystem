package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.Composable
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

abstract class AbstractQueryScreen(val description: String): AbstractScreen(description) {
    companion object {
        val listOfQueries = listOf<AbstractQueryScreen>(CargoVolumeStatQuery)
    }


    @Composable
    override fun content(navController: NavController) {
        inputContent()
        Table(getHead(), getData())
    }

    override fun onUpdate() {

    }

    @Composable
    override fun render() = render(QueryViewerScreen)

    abstract fun getHead(): List<String>

    abstract fun getData(): List<List<String>>

    @Composable
    abstract fun inputContent()
}