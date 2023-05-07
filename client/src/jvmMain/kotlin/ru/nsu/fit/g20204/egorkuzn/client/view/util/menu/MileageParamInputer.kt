package ru.nsu.fit.g20204.egorkuzn.client.view.util.menu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
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

    private val dropdownTransportMenu = GenericDropdownMenu<String>()

    @Composable
    private fun transportChooser(param: MutableState<String>) {
        dropdownTransportMenu.render(
            MileageInfoQuery.vehicleMap,
            param,
            "Транспорт"
        )
    }

    private val dropdownCategoryMenu = GenericDropdownMenu<String>()

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

    @Composable
    fun periodTypeChooser(periodType: MutableState<String>) {
        Row {
            RadioButton(
                selected = (periodType.value == "день"),
                onClick = {
                    periodType.value = "день"
                }
            )
            RadioButton(
                selected = (periodType.value == "месяц"),
                onClick = {
                    periodType.value = "месяц"
                }
            )
            RadioButton(
                selected = (periodType.value == "год"),
                onClick = {
                    periodType.value = "год"
                }
            )
        }
    }

    @Composable
    fun periodInputer(
        periodType: MutableState<String>,
        year: MutableState<String>,
        month: MutableState<String>,
        day: MutableState<String>
    ) = when(periodType.value) {
        "год" -> yearPeriod(year)
        "месяц" -> monthPeriod(year, month)
        "день" -> dayPeriod(year, month, day)
        else -> {}
    }

    @Composable
    private fun dayPeriod(year: MutableState<String>, month: MutableState<String>, day: MutableState<String>) {
        Row {
            var error by remember { mutableStateOf(false) }
            var newDayState by remember { mutableStateOf(day.value) }

            monthPeriod(year, month)
            TextField(
                value = newDayState,
                isError = error,
                onValueChange = { newValue ->
                    val newDayValue = newValue

                    if (newDayValue != null) {
                        newDayState = newDayValue

                        if (!error) {
                            day.value = newDayValue
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
        }
    }

    @Composable
    private fun monthPeriod(year: MutableState<String>, month: MutableState<String>) {
        Row {
            var error by remember { mutableStateOf(false) }
            var newMonthState by remember { mutableStateOf(month.value) }

            yearPeriod(year)
            TextField(
                value = newMonthState.toString(),
                isError = error,
                onValueChange = { newValue ->
                    val newMonthValue = newValue

                    if (newMonthValue != null) {
                        newMonthState = newMonthValue

                        if (!error) {
                            month.value = newMonthValue
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
        }
    }

    @Composable
    private fun yearPeriod(year: MutableState<String>) {
        var error by remember { mutableStateOf(false) }
        var newYearState by remember { mutableStateOf(year.value) }

        TextField(
            value = newYearState,
            isError = error,
            onValueChange = { newValue ->
                val newYearValue = newValue

                if (newYearValue != null) {
                    newYearState = newYearValue

                    if (!error) {
                        year.value = newYearValue
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }
}