package ru.nsu.fit.g20204.egorkuzn.server.model.entity.vehicle


import jakarta.persistence.*

@Entity
@Table(name = "Auxiliary models")
data class AuxiliaryModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    val modelId: Int,

    @Column(name = "model_name", nullable = false)
    val modelName: String,

    @Column(name = "description", nullable = false)
    val description: String
)