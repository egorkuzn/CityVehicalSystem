package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import java.sql.Date

object CargoVolumeStatQuery : AbstractQueryScreen(
    description = "Получение информации о грузоперевозках"
) {
    override fun getHead() = listOf(
        "Индентификатор транспорта",
        "Дата поездки",
        "Объем перевозимого груза",
        "Дистанция"
    )

    private val inputers = HashMap<String, String>(
        mapOf(
            Pair("Индентификатор транспорта", ""),
            Pair("Начальная дата", ""),
            Pair("Конечная дата", "")
        )
    )

    private var vehicleId = mutableStateOf(1L)
    private var dateFrom = mutableStateOf("2000-01-01")
    private var dateTo = mutableStateOf("2024-01-01")

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getCargoVolumeStat(
                vehicleId.value,
                dateFrom.value,
                dateTo.value
            ).map {
                listOf(
                    it.vehicle_id.toString(),
                    it.trip_date,
                    it.cargo_volume.toString(),
                    it.distance.toString()
                )
            }.toList()
    }


    @Composable
    override fun inputContent() {
        vehicleIdTextFiled(vehicleId)
        dateBox()
    }

    @Composable
    fun vehicleIdTextFiled(vehicleId: MutableState<Long>) {
        var error by remember { mutableStateOf(false) }
        var newVehicleId by remember { mutableStateOf(vehicleId.value) }

        TextField(
            value = newVehicleId.toString(),
            isError = error,
            onValueChange = { newValue ->
                val newLongValue = newValue.toLongOrNull()

                if (newLongValue != null) {
                    newVehicleId = newLongValue
                    error = newLongValue <= 0

                    if (!error) {
                        vehicleId.value = newLongValue
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }

    @Composable
    fun dateBox() {
        yearIntField()
        monthDropDownList()
        dayIntField()
    }

    @Composable
    fun yearIntField() {

    }

    @Composable
    fun monthDropDownList() {

    }

    @Composable
    fun dayIntField() {

    }
}
