package ru.nsu.fit.g20204.egorkuzn.client.view.util.field

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.nsu.fit.g20204.egorkuzn.client.view.util.menu.DropdownMonthMenu
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle

class DateField {
    private val monthMenu = DropdownMonthMenu()
    private val formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
        .withResolverStyle(ResolverStyle.STRICT)

    @Composable
    fun render(
        date: MutableState<String>
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            yearIntField(date)
            monthDropDownList(date)
        }
        dayIntField(date)
    }

    @Composable
    private fun yearIntField(date: MutableState<String>) {
        var error by remember { mutableStateOf(false) }
        var newYearState by remember { mutableStateOf(date.value.substring(0, 4)) }

        TextField(
            value = newYearState,
            isError = error,
            onValueChange = { newValue ->
                val newYearValue = newValue

                if (newYearValue.isNotEmpty()) {
                    newYearState = newYearValue

                    if (newYearState.length > 4)
                        newYearState = newYearState.substring(0, 4)

                    val tmp = newYearState + date.value.substring(4)

                    try {
                        LocalDate.parse(tmp, formatter)
                        error = false
                    } catch (e: DateTimeParseException) {
                        error = true
                    }

                    if (!error) {
                        date.value = tmp
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }

    @Composable
    private fun monthDropDownList(date: MutableState<String>) {
        monthMenu.render(
            listOf(
                Pair("Январь", "01"),
                Pair("Февраль", "02"),
                Pair("Март", "03"),
                Pair("Апрель", "04"),
                Pair("Май", "05"),
                Pair("Июнь", "06"),
                Pair("Июль", "07"),
                Pair("Август", "08"),
                Pair("Сентябрь", "09"),
                Pair("Октябрь", "10"),
                Pair("Ноябрь", "11"),
                Pair("Декабрь", "12")
                ),
            date
        )
    }

    @Composable
    private fun dayIntField(date: MutableState<String>) {
        var error by remember { mutableStateOf(false) }
        var newDayState by remember { mutableStateOf(date.value.substring(8)) }

        TextField(
            value = newDayState,
            isError = error,
            onValueChange = { newValue ->
                val newDayValue = newValue

                if (newDayValue.isNotEmpty()) {
                    newDayState = newDayValue

                    if(newDayState.length == 1)
                        newDayState = "0" + newDayState

                    newDayState = newDayState.substring(0, 2)

                    val tmp = date.value.substring(0, 8) + newDayState

                    try {
                        LocalDate.parse(tmp, formatter)
                        error = false
                    } catch (e: DateTimeParseException) {
                        error = true
                    }

                    if (!error) {
                        date.value = tmp
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }
}