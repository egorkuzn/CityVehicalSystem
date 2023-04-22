package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.managers

import jakarta.persistence.*
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit.Brigade

@Entity
@Table(name = "Brigadier")
data class Brigadier(
    @Id
    @Column(name = "human_id")
    val humanId: Int,

    @ManyToOne
    @JoinColumn(name = "brigade_id", nullable = false)
    val brigade: Brigade
)
