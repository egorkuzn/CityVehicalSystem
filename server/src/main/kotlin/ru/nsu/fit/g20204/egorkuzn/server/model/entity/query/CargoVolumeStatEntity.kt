package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity
import java.sql.Date

data class CargoVolumeStatEntity (
    val vehicle_id: Long,
    val trip_date: Date,
    val cargo_volume: Short,
    val distance: Short
): BaseEntity