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
class GenericDropdownMenu<T, K> {
    private var mExpanded by mutableStateOf(false)
    // Create a string value to store the selected city
    private var mSelectedText by mutableStateOf("")

    private var mTextFieldSize by mutableStateOf(Size.Zero)

    @Composable
    fun render(
        mapper: List<Pair<T, K>>, param: MutableState<K>,
        label: String
    ) {
        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown

        mSelectedText = mapper.firstOrNull { it.second == param.value }?.first.toString() ?: ""

        Column(Modifier.padding(20.dp)) {
            OutlinedTextField(value = mSelectedText,
                onValueChange = { mSelectedText = it },
                label = { Text(label) },
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
                        mSelectedText = it.first.toString()
                        mExpanded = false
                        param.value = it.second
                    }, text = {
                        Text(text = it.first.toString())
                    })
                }
            }
        }
    }
}
