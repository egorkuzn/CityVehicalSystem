package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.Composable
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

abstract class AbstractQueryScreen {
    companion object {
        val listOfQueries = ArrayList<AbstractQueryScreen>()
    }

    @Composable
    fun render(){
        Table(getHead(), getData())
    }

    abstract fun getHead(): List<String>

    abstract fun getData(): List<List<String>>
}