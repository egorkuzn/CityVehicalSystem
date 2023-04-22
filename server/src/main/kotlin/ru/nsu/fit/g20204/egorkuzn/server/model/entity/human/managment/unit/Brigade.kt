package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit

import jakarta.persistence.*

@Entity
@Table(name = "Brigades")
data class Brigade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brigade_id")
    val brigadeId: Int
)