package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.jpa.AccidentArea;

public interface StatisticRepository {

    void store(AccidentArea aa);

    AccidentArea[] findByRegion(String regionName);

}
