package ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.managers

import jakarta.persistence.*
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.human.managment.unit.Department

@Entity
@Table(name = "Department chief")
data class DepartmentChief(
    @Id
    @Column(name = "human_id")
    val humanId: Int,

    @ManyToOne
    @JoinColumn(name = "district_chef_id", nullable = false)
    val districtChief: DistrictChief,

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    val department: Department
)
