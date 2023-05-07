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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
class DropdownMonthMenu {
    private var mExpanded by mutableStateOf(false)

    // Create a string value to store the selected city
    private var mSelectedText by mutableStateOf("")




    @Composable
    fun render(
        mapper: List<Pair<String, String>>, vehicleId: MutableState<String>
    ) {
        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown

        mSelectedText = mapper.firstOrNull { it.second == vehicleId.value.substring(5, 7) }?.first ?: ""

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
        ) {
            OutlinedTextField(value = mSelectedText,
                onValueChange = { mSelectedText = it },
                label = { Text("Месяц") },
                trailingIcon = {
                    Icon(icon, "contentDescription", Modifier.clickable { mExpanded = !mExpanded })
                })

            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false }
            ) {
                mapper.forEach {
                    DropdownMenuItem(
                        onClick = {
                            mSelectedText = it.first
                            mExpanded = false
                            try {
                                vehicleId.value =
                                    vehicleId.value.substring(0, 5) + it.second + vehicleId.value.substring(7)
                            } catch (e: Exception) {
                                println(vehicleId.value)
                            }
                        },
                        text = {
                            Text(text = it.first)
                        }
                    )
                }
            }
        }
    }
}
