package ru.nsu.fit.g20204.egorkuzn.client.view.util.field

import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object IntField {
    @Composable
    fun render(
        label: String,
        mutableState: MutableState<Int>,
        error: MutableState<Boolean>
    ) {
        var newState by remember { mutableStateOf(mutableState.value) }

        OutlinedTextField(
            value = mutableState.value.toString(),
            isError = error.value,
            onValueChange = {
                val value = it.toIntOrNull()

                if (value != null) {
                    error.value = value <= 0
                    newState = value
                    mutableState.value = newState
                } else {
                    error.value = true
                }
            },
            modifier = Modifier.width(100.dp),
            label = { Text(text = label) }
        )
    }
}