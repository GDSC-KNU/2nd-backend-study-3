package com.backend3rd.BOGUdanyoKT.entity

import com.backend3rd.BOGUdanyoKT.dto.MyAccidentDto
import com.backend3rd.BOGUdanyoKT.dto.RouteAccidentDto
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "statistic")
class AccidentArea(
        @Id var id: Int,
        var address: String,
        var lon: Float,
        var lat: Float,
        var occur_cnt: Int,
        var caslt_cnt: Int,
        var death_cnt: Int,
        var sever_cnt: Int,
        var mild_cnt: Int
) {

    override fun toString(): String {
        return "address: " + this.address
    }

    fun toMyAccidentDto(): MyAccidentDto{
        return MyAccidentDto(accidentId = id, address = address, lat = lat, lon = lon)
    }

    fun toRouteAccidentDto(): RouteAccidentDto{
        return RouteAccidentDto(accidentId = id, address = address, lat = lat, lon = lon)
    }
}