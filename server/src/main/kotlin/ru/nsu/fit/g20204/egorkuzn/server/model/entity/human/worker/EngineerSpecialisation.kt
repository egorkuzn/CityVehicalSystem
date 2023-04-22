package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.worker

import jakarta.persistence.*

@Entity
@Table(name = "EngineerSpecialisation")
data class EngineerSpecialisation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisationid")
    val specialisationId: Int = 0,

    @Column(name = "description", nullable = false)
    val description: String
) {
    init {
        require(description.isNotBlank()) { "description must not be blank" }
    }
}

