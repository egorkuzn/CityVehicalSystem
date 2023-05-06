package ru.nsu.fit.g20204.egorkuzn.client.model.dto.query

import java.sql.Date

data class CargoVolumeStatDto (
    val vehicle_id: Long,
    val trip_date: String,
    val cargo_volume: Short,
    val distance: Short
)