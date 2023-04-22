package ru.nsu.fit.g20204.egorkuzn.server.model.entity.garage

import jakarta.persistence.*
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit.Department

@Entity
@Table(name = "Department place")
data class DepartmentPlace(
    @Id
    @Column(name = "department_place_id")
    val departmentPlaceId: Int,

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    val department: Department
)
