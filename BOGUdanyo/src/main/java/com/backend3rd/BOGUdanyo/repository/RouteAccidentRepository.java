package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.domain.Accident;
import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RouteAccidentRepository extends JpaRepository<Accident, Long> {

    @Query("select a from AccidentArea a where DEGREES(ACOS(SIN(RADIANS(a.lat))*SIN(RADIANS(:middleLat)) + COS(RADIANS(a.lat))*COS(RADIANS(:middleLat))*COS(RADIANS(a.lon-:middleLon))))* 60*1.1515*1609.344 < :radius")
    List<AccidentArea> findByRegion(@Param(value = "middleLat") double middleLat,
                                    @Param(value = "middleLon") double middleLon,
                                    @Param(value = "radius") double radius);
}
