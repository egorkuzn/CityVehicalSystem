package ru.nsu.fit.g20204.egorkuzn.client.view.util.field

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

object LongField {
    @Composable
    fun render(longState: MutableState<Long>) {
        var error by remember { mutableStateOf(false) }
        var newLongState by remember { mutableStateOf(longState.value) }

        TextField(
            value = newLongState.toString(),
            isError = error,
            onValueChange = { newValue ->
                val newLongValue = newValue.toLongOrNull()

                if (newLongValue != null) {
                    newLongState = newLongValue
                    error = newLongValue <= 0

                    if (!error) {
                        longState.value = newLongValue
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }
}