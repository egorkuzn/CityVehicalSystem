package ru.nsu.fit.g20204.egorkuzn.client.view.util.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
object DropdownCategoryMenu {
    private var mExpanded by mutableStateOf(false)
    // Create a string value to store the selected city
    private var mSelectedText by mutableStateOf("")

    private var mTextFieldSize by mutableStateOf(Size.Zero)

    private val mapper = listOf(
        Pair("Такси", "Taxi"),
        Pair("Грузовик", "Truck"),
        Pair("Авто", "Car"),
        Pair("Маршрутка", "Shuttle"),
        Pair("Спец транспорт", "Auxiliary"),
        Pair("Автобус", "Bus")
    )
    
    @Composable
    fun render(param: MutableState<String>) {
        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown

        mSelectedText = mapper.firstOrNull { it.second == param.value }?.first ?: ""

        Column(Modifier.padding(20.dp)) {
            OutlinedTextField(value = mSelectedText,
                onValueChange = { mSelectedText = it },
                label = { Text("Категория") },
                trailingIcon = {
                    Icon(icon, "contentDescription", Modifier.clickable { mExpanded = !mExpanded })
                },
                readOnly = true
            )

            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false }
            ) {
                mapper.forEach {
                    DropdownMenuItem(onClick = {
                        mSelectedText = it.first
                        mExpanded = false
                        param.value = it.second
                    }, text = {
                        Text(text = it.first)
                    })
                }
            }
        }
    }   
    
}