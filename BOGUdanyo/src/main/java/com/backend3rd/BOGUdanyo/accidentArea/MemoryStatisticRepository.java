package com.backend3rd.BOGUdanyo.accidentArea;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class MemoryStatisticRepository implements StatisticRepository{

    private static ArrayList<AccidentArea> repo = new ArrayList<>();

    @Override
    public void store(AccidentArea aa) {
        repo.add(aa);
    }

    @Override
    public AccidentArea[] findByRegion(String regionName) {
        ArrayList<AccidentArea> areasOfRegion = new ArrayList<>();
        for (AccidentArea aa : repo) {
            if(aa.getAddress() == regionName){
                areasOfRegion.add(aa);
            }
        }
        return areasOfRegion.toArray(new AccidentArea[0]);
    }
}
