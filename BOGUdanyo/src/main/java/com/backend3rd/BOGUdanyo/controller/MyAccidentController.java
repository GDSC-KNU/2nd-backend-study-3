package com.backend3rd.BOGUdanyo.controller;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.service.MyAccidentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyAccidentController {

    @Autowired
    MyAccidentService myAccidentService;

    @GetMapping("/myAccidents")
    public List<MyAccidentDto> getmyAccidents(@RequestParam("start") String start) throws ParseException {
        List<AccidentArea> findmyAccidents = myAccidentService.getMyAccident(start);
        List<MyAccidentDto> collect = findmyAccidents.stream()
                .map(m -> new MyAccidentDto(m.getId(), m.getAddress(), m.getLat(), m.getLon()))
                .collect(Collectors.toList());

        return collect;
    }


    @Data
    @AllArgsConstructor
    static class MyAccidentDto {
        private int accidentId;
        private String address;
        private float lat;
        private float lon;
    }

}
