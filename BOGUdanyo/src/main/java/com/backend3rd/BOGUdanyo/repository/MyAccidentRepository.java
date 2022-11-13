package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MyAccidentRepository extends JpaRepository<AccidentArea, Integer> {

    @Query("select a from AccidentArea a where DEGREES(ACOS(SIN(RADIANS(a.lat))*SIN(RADIANS(:startLat)) + COS(RADIANS(a.lat))*COS(RADIANS(:startLat))*COS(RADIANS(a.lon-:startLon))))* 60*1.1515*1609.344 < 10000")
    List<AccidentArea> findByRegion(@Param(value = "startLat") float startLat,
                                    @Param(value = "startLon") float startLon);

}
