package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit

import jakarta.persistence.*

@Entity
@Table(name = "District")
data class District(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    val districtId: Int,

    @Column(name = "firstname", nullable = false)
    val firstname: String,

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    val department: Department
)
