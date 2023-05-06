package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.map.TruckToIdDto
import ru.nsu.fit.g20204.egorkuzn.client.view.util.field.DateField
import ru.nsu.fit.g20204.egorkuzn.client.view.util.menu.DropdownTruckMenu

object CargoVolumeStatQuery : AbstractQueryScreen(
    description = "Получение информации о грузоперевозках"
) {

    override fun getHead() = listOf(
        "Дата поездки",
        "Объем перевозимого груза",
        "Дистанция"
    )

    private var vehicleId = mutableStateOf(1L)
    private var dateFrom = mutableStateOf("2000-01-01")
    private var dateTo = mutableStateOf("2024-01-01")
    private var mapper: List<TruckToIdDto> = emptyList()
    private var isFirstTime = true
    private var dateFromField = DateField()
    private var dateToField = DateField()

    override fun getData() = runBlocking {
        if (isFirstTime) launch {
            mapper = RetrofitBuilder
                .apiImpl()
                .getTruckToVehicleId()
        }

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

    init {
        getData()
        isFirstTime = false
    }

    @Composable
    override fun inputContent() {
        DropdownTruckMenu.render(mapper, vehicleId)
        dateFromField.render(dateFrom)
        dateToField.render(dateTo)
    }
}
