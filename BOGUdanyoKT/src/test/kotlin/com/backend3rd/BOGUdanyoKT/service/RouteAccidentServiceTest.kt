package com.backend3rd.BOGUdanyoKT.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RouteAccidentServiceTest (
        @Autowired val routeAccidentService: RouteAccidentService
        ){

        @Test
        @DisplayName("service 테스트")
        fun routeAccidentServTest(){
                var start = "대구광역시 달서구 선원남로 181"
                var goal = "대구광역시 북구 대학로 80"

                val result = routeAccidentService.getRoutAccident(start, goal)

                for (accidentArea in result) {
                        println(accidentArea.toString())
                }
        }
}