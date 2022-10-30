package com.backend3rd.BOGUdanyo.service;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;

public interface StatisticSearchService {

    void addData(String regionName, float lon, float lat, int occur_cnt, int caslt_cnt, int death_cnt, int sever_cnt, int mild_cnt);

    AccidentArea[] getRankedArea(String regionName);
}
