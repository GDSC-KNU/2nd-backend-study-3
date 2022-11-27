package com.backend3rd.BOGUdanyoKT.controller

import com.backend3rd.BOGUdanyoKT.dto.MyAccidentDto
import com.backend3rd.BOGUdanyoKT.service.MyAccidentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MyAccidentController (
        @Autowired val myAccidentService: MyAccidentService
        ){

        @GetMapping("/myAccidents")
        fun getMyAccidents(@RequestParam("startLat") startLat:Float, @RequestParam("startLon") startLon: Float): List<MyAccidentDto>{
                var result = myAccidentService.getMyAccident(startLat, startLon)
                return result.map { it.toMyAccidentDto() }
        }
}