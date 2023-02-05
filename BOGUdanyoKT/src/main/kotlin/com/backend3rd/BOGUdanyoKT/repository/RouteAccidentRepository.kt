package com.backend3rd.BOGUdanyoKT.repository

import com.backend3rd.BOGUdanyoKT.entity.AccidentArea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RouteAccidentRepository: JpaRepository<AccidentArea, Int> {

    @Query("select a from AccidentArea a where DEGREES(ACOS(SIN(RADIANS(a.lat))*SIN(RADIANS(:middleLat)) + COS(RADIANS(a.lat))*COS(RADIANS(:middleLat))*COS(RADIANS(a.lon-:middleLon))))* 60*1.1515*1609.344 < :radius")
    fun findByRegion(@Param("middleLat") middleLat:Float,
                     @Param("middleLon") middleLon:Float,
                     @Param("radius") radius:Double) : List<AccidentArea>
}