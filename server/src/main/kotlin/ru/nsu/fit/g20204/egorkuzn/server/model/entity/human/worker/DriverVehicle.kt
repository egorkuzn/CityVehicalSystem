package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.worker

import jakarta.persistence.*
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.vehicle.Vehicle

@Entity
@Table(name = "DriversVehicles")
data class DriverVehicle(
    @Id
    @ManyToOne
    @JoinColumn(name = "driverid", referencedColumnName = "workerid")
    val driver: Driver,

    @Id
    @ManyToOne
    @JoinColumn(name = "vehicleid", referencedColumnName = "id")
    val vehicle: Vehicle
) {
    init {
        require(driver.workerId > 0) { "driver.workerId must be greater than 0" }
        require(vehicle.id > 0) { "vehicle.id must be greater than 0" }
    }
}
