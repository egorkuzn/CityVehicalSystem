package ru.nsu.fit.g20204.egorkuzn.server.model.entity.garage

import jakarta.persistence.*

@Entity
@Table(name = "Garages")
data class Garage(
    @Id
    @Column(name = "garageid")
    val garageId: Int
) {
    init {
        require(garageId > 0) { "garageId must be greater than 0" }
    }
}
