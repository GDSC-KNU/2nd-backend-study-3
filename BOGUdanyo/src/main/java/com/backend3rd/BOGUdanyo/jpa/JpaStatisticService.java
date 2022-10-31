package com.backend3rd.BOGUdanyo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JpaStatisticService {

    @Autowired
    private JpaStatisticRepository jpaStatisticRepository;

    public List<AccidentArea> getRankedArea(String region){
        List<AccidentArea> list = jpaStatisticRepository.findByRegionStartsWith(region);
        Collections.sort(list);
        return list;
    }
}
