package com.backend3rd.BOGUdanyo.controller;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.service.RouteAccidentService;
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
public class RouteAccidentController {

    @Autowired
    RouteAccidentService accidentService;

    @GetMapping("/route")
    public List<RouteAccidentDto> getRouteAccident(@RequestParam("start") String start, @RequestParam("goal") String goal) throws ParseException {

        List<AccidentArea> findRouteAccident = accidentService.getRouteAccident(start, goal);

        List<RouteAccidentDto> collect = findRouteAccident.stream()
        .map(m -> new RouteAccidentDto(m.getId(), m.getAddress(), m.getLat(), m.getLon()))
        .collect(Collectors.toList());

        return collect;
    }

    @Data
    @AllArgsConstructor
    static class RouteAccidentDto {
        private int accidentId;
        private String address;
        private float lat;
        private float lon;
    }
}
