package com.backend3rd.BOGUdanyoKT.controller

import com.backend3rd.BOGUdanyoKT.dto.RouteAccidentDto
import com.backend3rd.BOGUdanyoKT.service.RouteAccidentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RouteAccidentController (
        @Autowired val routeAccidentService: RouteAccidentService
        ){

    @GetMapping("/route")
    fun getRouteAccident(@RequestParam("start") start:String, @RequestParam("goal") goal: String): List<RouteAccidentDto> {
        var findRouteAccident = routeAccidentService.getRoutAccident(start, goal)
        return findRouteAccident.map { it.toRouteAccidentDto() }
    }
}