package ru.nsu.fit.g20204.egorkuzn.client.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController

object QueryViewerScreen : AbstractScreen(
    label = "Просмотрщик запросов",
    icon = Icons.Filled.Search
) {
    init {
        screensList.add(this)
    }

    @Composable
    override fun render(navController: NavController) = render(MenuScreen, navController)

    private var expanded by mutableStateOf(true)
    private val suggestions = listOf("Item1", "Item2", "Item3")
    private var selectedText by mutableStateOf("")
    private var textFieldSize by mutableStateOf(Size.Zero)

    @Composable
    override fun content(navController: NavController) {
        Box() {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("Label") }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedText = label
                    }) {
                        Text(text = label)
                    }
                }
            }
        }

    }

    override fun onUpdate() {

    }
}