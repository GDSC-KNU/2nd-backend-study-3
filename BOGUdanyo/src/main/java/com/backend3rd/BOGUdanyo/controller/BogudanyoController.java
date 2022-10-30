package com.backend3rd.BOGUdanyo.controller;

import org.json.simple.parser.ParseException;
import com.backend3rd.BOGUdanyo.service.BogudanyoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BogudanyoController {

    @Autowired
    BogudanyoService bogudanyoService;

    @GetMapping("/myAccidentArea")
    public float[][] given_startgoal_returnXY(@RequestParam("start") String start, @RequestParam("goal") String goal) throws ParseException {

        float[][] myAccidentArea = bogudanyoService.findMyAccidentArea(start, goal);
        return myAccidentArea;
    }

}
