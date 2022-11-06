package com.backend3rd.BOGUdanyo.controller;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.service.RouteAccidentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RouteAccidentController {

    RouteAccidentService accidentService;

    @PutMapping("/api/route")
    public routeAccidentResult getRouteAccident(@RequestParam("start") String start, @RequestParam("goal") String goal) throws ParseException {
        List<AccidentArea> findRouteAccident = accidentService.getRouteAccident(start, goal);
        List<RouteAccidentDto> collect = findRouteAccident.stream()
                .map(m -> new RouteAccidentDto(m.getId(), m.getAddress(), m.getLat(), m.getLon()))
                .collect(Collectors.toList());

        return new routeAccidentResult(collect);
    }
    @Data
    private class routeLocationRequest {
        private float startX;
        private float startY;
        private float goalX;
        private float goalY;
    }

    @Data
    @AllArgsConstructor
    static class routeAccidentResult<T> {
        private T data;
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
