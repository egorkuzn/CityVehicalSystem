package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.worker

import jakarta.persistence.*

@Entity
@Table(name = "Drivers")
data class Driver(
    @Id
    @Column(name = "workerid")
    val workerId: Int,

    @OneToOne
    @JoinColumn(name = "workerid", referencedColumnName = "id")
    val worker: Worker
)
