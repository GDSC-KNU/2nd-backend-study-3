package com.backend3rd.BOGUdanyo.controller;

import com.backend3rd.BOGUdanyo.jpa.AccidentArea;
import com.backend3rd.BOGUdanyo.jpa.JpaStatisticService;
import org.json.simple.parser.ParseException;
import com.backend3rd.BOGUdanyo.service.BogudanyoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BogudanyoController {

    @Autowired
    BogudanyoService bogudanyoService;

    @Autowired
    JpaStatisticService jpaStatisticService;

    @GetMapping("/myAccidentArea")
    public float[][] given_startgoal_returnXY(@RequestParam("start") String start, @RequestParam("goal") String goal) throws ParseException {

        float[][] myAccidentArea = bogudanyoService.findMyAccidentArea(start, goal);
        return myAccidentArea;
    }

    // 'localhost:8080/statisticArea?region=서울특별시_강남구'
    @GetMapping("/statisticArea")
    public List<AccidentArea> getStatistics(@RequestParam("region") String region){
        region.replaceAll("_", " ");
        List<AccidentArea> rankedArea = jpaStatisticService.getRankedArea(region);
        return rankedArea;
    }
}
