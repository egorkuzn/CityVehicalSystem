package ru.nsu.fit.g20204.egorkuzn.client.view.util.field

import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object StringField {
    @Composable
    fun render(
        label: String,
        mutableState: MutableState<String>,
        error: MutableState<Boolean>
    ) {
        var newState by remember { mutableStateOf(mutableState.value) }

        OutlinedTextField(
            value = mutableState.value,
            isError = error.value,
            onValueChange = {
                if (it.isNotEmpty()) {
                    error.value = false
                    newState = it
                    mutableState.value = newState
                } else {
                    error.value = true
                }
            },
            modifier = Modifier.width(200.dp),
            label = {Text(text = label)}
        )
    }
}