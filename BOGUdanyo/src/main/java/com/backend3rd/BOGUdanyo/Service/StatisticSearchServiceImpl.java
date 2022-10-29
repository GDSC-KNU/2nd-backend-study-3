package com.backend3rd.BOGUdanyo.Service;

import com.backend3rd.BOGUdanyo.accidentArea.AccidentArea;
import com.backend3rd.BOGUdanyo.accidentArea.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StatisticSearchServiceImpl implements StatisticSearchService{

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticSearchServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void addData(String regionName, float lon, float lat, int occur_cnt, int caslt_cnt, int death_cnt, int sever_cnt, int mild_cnt) {
        AccidentArea aa = new AccidentArea(regionName, lon, lat, occur_cnt, caslt_cnt, death_cnt, sever_cnt, mild_cnt);
        statisticRepository.store(aa);
    }

    @Override
    public AccidentArea[] getRankedArea(String regionName) {
        AccidentArea[] areasOfRegion = statisticRepository.findByRegion(regionName);

        Arrays.sort(areasOfRegion);

        return areasOfRegion;
    }
}
