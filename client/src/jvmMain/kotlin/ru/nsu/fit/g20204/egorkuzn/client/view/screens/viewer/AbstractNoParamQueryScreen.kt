package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

abstract class AbstractNoParamQueryScreen(description: String) : AbstractQueryScreen(description) {
    private var data: MutableState<List<List<String>>> = mutableStateOf(emptyList())

    @Composable
    override fun queryContent() {
        Table(getHead(), data.value)
    }

    @Composable
    override fun render() = render(QueryViewerScreen)

    override fun loadFunction() {
        data.value = getData()
    }
}