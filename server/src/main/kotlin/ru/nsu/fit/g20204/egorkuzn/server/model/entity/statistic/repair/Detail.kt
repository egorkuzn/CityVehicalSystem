package ru.nsu.fit.g20204.egorkuzn.server.model.entity.statistic.repair

import jakarta.persistence.*

@Entity
@Table(name = "Details")
data class Detail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    val detailId: Int,

    @Column(name = "description", nullable = false)
    val description: String
)

