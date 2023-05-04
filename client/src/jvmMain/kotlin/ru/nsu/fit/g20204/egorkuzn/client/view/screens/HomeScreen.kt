package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.table.Table

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(navController.currentScreen.value)
        Button(
            onClick = {
                navController.navigate(Screen.RepairsStatTransport.name)
            }) {
            Text("Navigate to Profile")
        }

        val tableData = (1..100).map { listOf(it.toString(), "Item $it") }

        Table(
            listOf(
                "[][][][][][][][][][][][][][][][][][][][][][][][][][]][]][]",
                "Cell               2",
                "Cell               3",
                "Cell               4",
                "[][][][][][][][][][][][][][][][][][][][][][][][][][]][]][]",
                "Cell               2",
                "Cell               3",
                "Cell               4"
            ),
            tableData
        )
    }
}