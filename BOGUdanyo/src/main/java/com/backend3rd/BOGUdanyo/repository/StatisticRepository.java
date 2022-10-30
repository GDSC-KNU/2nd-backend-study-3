package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;

public interface StatisticRepository {

    void store(AccidentArea aa);

    AccidentArea[] findByRegion(String regionName);

}
