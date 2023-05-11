package ru.nsu.fit.g20204.egorkuzn.client.view.screens.editor

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.EditingMasterScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

@OptIn(ExperimentalFoundationApi::class)
abstract class AbstractEditorScreen(val description: String) : AbstractScreen(description) {
    private var data: MutableState<List<List<String>>> = mutableStateOf(emptyList())

    companion object {
        val listOfEditors = listOf(
            AuxiliaryModelEditor,
            BusModelEditor,
            CarModelEditor,
            ShuttleModelEditor,
            TruckModelEditor
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
                editorContent()
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

    private fun loadFunction() {
        data.value = getData()
    }

    @Composable
    fun editorContent() {
        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState()
        val tabList = listOf("Добавить", "Удалить", "Обновить", "Таблица")
        val tabIndex = pagerState.currentPage

        Column {
            TabRow(
                selectedTabIndex = tabIndex
            ) {
                tabList.forEachIndexed { index, text ->
                    Tab(
                        selected = false,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            androidx.compose.material3.Text(text = text)
                        },
                    )
                }
            }

            HorizontalPager(
                pageCount = tabList.size,
                state = pagerState,
                modifier = Modifier.weight(1.0f)
            ) { currentPage ->
                when(currentPage) {
                    0 -> addContent()
                    1 -> deleteContent()
                    2 -> updateContent()
                    else -> Table(getHead(), data.value)
                }
            }
        }
    }

    override fun onUpdate() {
        isLaunched = !isLaunched
    }

    @Composable
    abstract fun updateContent()

    @Composable
    abstract fun deleteContent()

    @Composable
    abstract fun addContent()

    @Composable
    override fun render() = render(EditingMasterScreen)

    abstract fun getHead(): List<String>

    abstract fun getData(): List<List<String>>
}