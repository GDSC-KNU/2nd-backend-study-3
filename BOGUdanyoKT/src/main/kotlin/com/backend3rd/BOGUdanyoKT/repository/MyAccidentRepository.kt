package com.backend3rd.BOGUdanyoKT.repository

import com.backend3rd.BOGUdanyoKT.entity.AccidentArea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MyAccidentRepository : JpaRepository<AccidentArea, Int>{

    @Query("select a from AccidentArea a where DEGREES(ACOS(SIN(RADIANS(a.lat))*SIN(RADIANS(:startLat)) + COS(RADIANS(a.lat))*COS(RADIANS(:startLat))*COS(RADIANS(a.lon-:startLon))))* 60*1.1515*1609.344 < 10000")
    fun findByRegion(@Param("startLat") startLat: Float, @Param("startLon") startLon: Float): List<AccidentArea>
}