package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.QueryViewerScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

@OptIn(ExperimentalFoundationApi::class)
abstract class AbstractParamQueryScreen(description: String) : AbstractQueryScreen(description) {
    private var data: MutableState<List<List<String>>> = mutableStateOf(emptyList())

    @Composable
    override fun queryContent() {
        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState()
        val tabList = listOf("Фильтр", "Таблица")
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
                            Text(text = text)
                        },
                    )
                }
            }

            HorizontalPager(
                pageCount = tabList.size,
                state = pagerState,
                modifier = Modifier.weight(1.0f)
            ) { currentPage ->
                if (currentPage == 0)
                    inputContent()
                else
                    Table(getHead(), data.value)
            }
        }
    }

    override fun loadFunction() {
        data.value = getData()
    }

    @Composable
    override fun render() = render(QueryViewerScreen)

    @Composable
    abstract fun inputContent()
}