package ru.nsu.fit.g20204.egorkuzn.server.model.entity.vehicle.passenger_model

import jakarta.persistence.*

@Entity
@Table(name = "Buses models")
data class BusModel(
    @Id
    @Column(name = "bus_model_id")
    val busModelId: Int,

    @Column(name = "model_name", nullable = false)
    val modelName: String,

    @ManyToOne
    @JoinColumn(name = "bus_model_id", nullable = false)
    val passengerTransportModel: PassengerTransportModel
)
