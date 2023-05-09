package ru.nsu.fit.g20204.egorkuzn.client.view.util.menu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param.MileageInfoQuery
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle

object MileageParamInputer {
    private val formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
        .withResolverStyle(ResolverStyle.STRICT)

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

    val dropdownTransportMenu = GenericDropdownMenu<String>()

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
        year: MutableState<Int>,
        month: MutableState<Int>,
        day: MutableState<Int>
    ) = when (periodType.value) {
        "год" -> yearPeriod(year)
        "месяц" -> monthPeriod(year, month)
        "день" -> dayPeriod(year, month, day)
        else -> {}
    }

    @Composable
    private fun dayPeriod(year: MutableState<Int>, month: MutableState<Int>, day: MutableState<Int>) {
        Row {
            var error by remember { mutableStateOf(false) }
            var newDayState by remember { mutableStateOf(day.value) }

            monthPeriod(year, month)
            OutlinedTextField(
                value = newDayState.toString(),
                isError = error,
                onValueChange = { newValue ->
                    val newDayValue = newValue.toIntOrNull()

                    if (newDayValue != null) {
                        newDayState = newDayValue

                        try {
                            if (day.value < 10) {
                                LocalDate.parse("${year.value}-${month.value}-0${day.value}", formatter)
                            } else {
                                LocalDate.parse("${year.value}-${month.value}-${day.value}", formatter)
                            }
                        } catch (e: DateTimeParseException) {
                            error = true
                        }

                        if (!error) {
                            day.value = newDayValue
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                label = { Text("День") }
            )
        }
    }

    @Composable
    private fun monthPeriod(year: MutableState<Int>, month: MutableState<Int>) {
        Row {
            val genericDropdownMenu by remember { mutableStateOf(GenericDropdownMenu<Int>()) }

            yearPeriod(year)
            genericDropdownMenu.render(
                listOf(
                    Pair("Январь", 1),
                    Pair("Февраль", 2),
                    Pair("Март", 3),
                    Pair("Апрель", 4),
                    Pair("Май", 5),
                    Pair("Июнь", 6),
                    Pair("Июль", 7),
                    Pair("Август", 8),
                    Pair("Сентябрь", 9),
                    Pair("Октябрь", 10),
                    Pair("Ноябрь", 11),
                    Pair("Декабрь", 12)
                ),
                month,
                "Месяц"
            )
        }
    }

    @Composable
    private fun yearPeriod(year: MutableState<Int>) {
        var error by remember { mutableStateOf(false) }
        var newYearState by remember { mutableStateOf(year.value) }

        OutlinedTextField(
            value = newYearState.toString(),
            isError = error,
            onValueChange = { newValue ->
                val newYearValue = newValue.toIntOrNull()

                if (newYearValue != null) {
                    newYearState = newYearValue

                    error = newYearState <= 1900 || newYearState >= 10000

                    if (!error) {
                        year.value = newYearValue
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            label = { Text("Год") }
        )
    }
}