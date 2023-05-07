package ru.nsu.fit.g20204.egorkuzn.client.view.util.menu

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param.MileageInfoQuery

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
    fun paramInputer(param: MutableState<String>, paramType: MutableState<String>) = when (paramType.value) {
        "категория" -> categoryChooser(param)
        "id" -> transportChooser(param)
        else -> {}
    }

    private val dropdownTransportMenu = GenericDropdownMenu<String, String>()

    @Composable
    private fun transportChooser(param: MutableState<String>) {
        dropdownTransportMenu.render(
            MileageInfoQuery.vehicleMap,
            param,
            "Транспорт"
        )
    }

    private val dropdownCategoryMenu = GenericDropdownMenu<String, String>()

    @Composable
    private fun categoryChooser(param: MutableState<String>) {
        dropdownCategoryMenu.render(
            listOf(
                Pair("Такси", "Taxi"),
                Pair("Грузовик", "Truck"),
                Pair("Авто", "Car"),
                Pair("Маршрутка", "Shuttle"),
                Pair("Спец транспорт", "Auxiliary"),
                Pair("Автобус", "Bus")
            ),
            param,
            "Категория"
        )
    }
}