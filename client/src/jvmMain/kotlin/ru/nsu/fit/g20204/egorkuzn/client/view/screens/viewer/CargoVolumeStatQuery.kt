package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.*
import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.field.DateField
import ru.nsu.fit.g20204.egorkuzn.client.view.field.LongField

object CargoVolumeStatQuery : AbstractQueryScreen(
    description = "Получение информации о грузоперевозках"
) {
    override fun getHead() = listOf(
        "Индентификатор транспорта",
        "Дата поездки",
        "Объем перевозимого груза",
        "Дистанция"
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
                    it.trip_date,
                    it.cargo_volume.toString(),
                    it.distance.toString()
                )
            }.toList()
    }


    @Composable
    override fun inputContent() {
        LongField.render(mapvehicleId)
        DateField.render()
        DateField.render()
    }
}
