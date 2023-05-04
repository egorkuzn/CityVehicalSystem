package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

@Composable
fun TableScreen(
    head: List<String>,
    tableData: List<List<String>>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Table(
            head,
            tableData
        )
    }
}