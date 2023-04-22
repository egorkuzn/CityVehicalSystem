package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.worker

import jakarta.persistence.*

@Entity
@Table(name = "Engineers")
data class Engineer(
    @Id
    @Column(name = "engineerid")
    val engineerId: Int,

    @ManyToOne
    @JoinColumn(name = "specialisationid", referencedColumnName = "specialisationid")
    val specialisation: EngineerSpecialisation
) {
    init {
        require(engineerId > 0) { "engineerId must be greater than 0" }
        require(specialisation.specialisationId > 0) { "specialisation.specialisationId must be greater than 0" }
    }
}


