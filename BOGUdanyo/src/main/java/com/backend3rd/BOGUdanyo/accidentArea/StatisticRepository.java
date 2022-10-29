package com.backend3rd.BOGUdanyo.accidentArea;

public interface StatisticRepository {

    void store(AccidentArea aa);

    AccidentArea[] findByRegion(String regionName);

}
