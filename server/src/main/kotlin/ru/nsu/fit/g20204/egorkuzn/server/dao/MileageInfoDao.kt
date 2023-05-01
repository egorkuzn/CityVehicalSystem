package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.MileageInfoEntity
import java.sql.ResultSet

@Repository
class MileageInfoDao(@Autowired jdbcConfig: JdbcConfig) : BaseDao<MileageInfoEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        MileageInfoEntity(
            getLong("Vehicle id"),
            getInt("Mileage")
        )
    }

    fun runQuery(
        paramType: String,
        param: String,
        periodType: String,
        day: String,
        month: String,
        year: String
    ) = sqlRun(
        """
            select V.vehicle_id as "Vehicle id",
                sum(T.distance) as "Mileage"
            from "Vehicle" V left join "Vehicle-Bus model" on V.vehicle_id = "Vehicle-Bus model".vehicle_id
                    left join "Vehicle-Taxi model" on V.vehicle_id="Vehicle-Taxi model".vehicle_id
                    left join "Vehicle-Truck model" on V.vehicle_id = "Vehicle-Truck model".vehicle_id
                    left join "Vehicle-Auxiliary model" on V.vehicle_id = "Vehicle-Auxiliary model".vehicle_id
                    left join "Vehicle-Car model" on V.vehicle_id = "Vehicle-Car model".vehicle_id
                    left join "Vehicle-Shuttle model" on V.vehicle_id = "Vehicle-Shuttle model".vehicle_id,
                 "Trips" as T
            where case
                    when '$paramType' = 'категория' then
                        case
                        when '$param' = 'Taxi' then V.vehicle_id = "Vehicle-Taxi model".vehicle_id
                        when '$param' = 'Truck' then V.vehicle_id = "Vehicle-Truck model".vehicle_id
                        when '$param' = 'Car' then V.vehicle_id = "Vehicle-Car model".vehicle_id
                        when '$param' = 'Shuttle' then V.vehicle_id = "Vehicle-Shuttle model".vehicle_id
                        when '$param' = 'Auxiliary' then V.vehicle_id = "Vehicle-Auxiliary model".vehicle_id
                        when '$param' = 'Bus' then V.vehicle_id = "Vehicle-Bus model".vehicle_id
                            else true
                        end
                    when '$paramType' = 'id' then V.vehicle_id::text = '$param'
                end
              and T.vehicle_id = V.vehicle_id
                and case
                        when '$periodType' = 'день' then
                            extract(day from T.trip_date) = '$day'
                            and extract(month from T.trip_date) = '$month'
                            and extract(year from T.trip_date) = '$year'
                        when '$periodType' = 'месяц' then
                            extract(month from T.trip_date) = '$month'
                            and extract(year from T.trip_date) = '$year'
                        when '$periodType' = 'год' then extract(year from T.trip_date) = '$year'
                    end
            group by V.vehicle_id;
        """.trimIndent()
    )
}