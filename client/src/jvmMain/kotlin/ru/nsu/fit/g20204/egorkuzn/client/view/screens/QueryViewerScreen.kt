package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractQueryScreen

object QueryViewerScreen : AbstractScreen(
    label = "Просмотрщик запросов"
) {
    init {
        screensList.add(this)
    }

    val queryList by mutableStateOf(AbstractQueryScreen.listOfQueries)

    @Composable
    override fun render() = render(MenuScreen)

    @Composable
    override fun content(navController: NavController) {
        Column {
            LazyColumn {
                items(queryList) {
                    Button(
                        onClick = {
                            navController.navigate(it)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 0.dp)
                    ) {
                        Text(
                            text = it.description,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    override fun onUpdate() {

    }
}