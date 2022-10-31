package com.backend3rd.BOGUdanyo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaStatisticRepository extends JpaRepository<AccidentArea, Integer> {

    @Query("select a from AccidentArea a where a.address like :region%")
    List<AccidentArea> findByRegionStartsWith(@Param(value = "region") String region);
}
