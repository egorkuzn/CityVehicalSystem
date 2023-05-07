package ru.nsu.fit.g20204.egorkuzn.client.view.util.menu

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

// "день" "месяц" "год"
object MileageParamInputer {
    @Composable
    fun paramTypeChooser(paramType: MutableState<String>) {
        Row {
            RadioButton(
                selected = (paramType.value == "категория"),
                onClick = {
                    paramType.value = "категория"
                }
            )
            RadioButton(
                selected = (paramType.value == "id"),
                onClick = {
                    paramType.value = "id"
                }
            )
        }
    }

    @Composable
    fun paramInputer(param: MutableState<String>, paramType: MutableState<String>) = when(paramType.value){
            "категория" -> categoryChooser(param)
            "id" -> transportChooser(param)
        }

    @Composable
    private fun transportChooser(param: MutableState<String>) {

    }

    @Composable
    private fun categoryChooser(param: MutableState<String>) {
        DropdownCategoryMenu.render()
    }
}