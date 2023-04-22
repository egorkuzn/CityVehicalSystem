package ru.nsu.fit.g20204.egorkuzn.server.model.entity.vehicle.passenger_model

import jakarta.persistence.*

@Entity
@Table(name = "Cars models")
data class CarModel(
    @Id
    @Column(name = "car_model_id")
    val carModelId: Int,

    @Column(name = "model_name", nullable = false)
    val modelName: String,

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    val passengerTransportModel: PassengerTransportModel
)