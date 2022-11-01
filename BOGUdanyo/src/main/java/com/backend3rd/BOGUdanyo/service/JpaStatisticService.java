package com.backend3rd.BOGUdanyo.service;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.repository.JpaStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@PropertySource(value={"classpath:application.properties"})
public class JpaStatisticService {

    @Autowired
    private JpaStatisticRepository jpaStatisticRepository;

    public List<AccidentArea> getRankedArea(String region){
        List<AccidentArea> list = jpaStatisticRepository.findByRegionStartsWith(region);
        Collections.sort(list);
        return list;
    }
}
