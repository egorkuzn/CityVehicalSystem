package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit

import jakarta.persistence.*

@Entity
@Table(name = "Department")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    val departmentId: Int,

    @Column(name = "name", nullable = false)
    val name: String
)
