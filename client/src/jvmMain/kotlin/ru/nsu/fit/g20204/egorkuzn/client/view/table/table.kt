package ru.nsu.fit.g20204.egorkuzn.client.view.table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Table(
    head: List<String>,
    tableData: List<List<String>>
) {
    Column {
        TableHead(head)
        TableData(tableData)
    }
}

@Composable
fun TableHead(head: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color.Gray)
    ) {
        head.forEach {
            TableCell(it)
        }
    }
}

@Composable
fun TableData(tableData: List<List<String>>) {
    Column (modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(tableData) {
                Row(Modifier.fillMaxWidth()) {
                    it.forEach {
                        TableCell(it)
                    }
                }
                Divider()
            }
        }
    }
}