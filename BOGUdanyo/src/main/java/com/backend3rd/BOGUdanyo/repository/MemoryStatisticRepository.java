package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;

import java.util.ArrayList;

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
