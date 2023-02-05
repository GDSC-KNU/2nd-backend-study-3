package com.backend3rd.BOGUdanyoKT.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class MyAccidentServiceTest (
        @Autowired val myAccidentService: MyAccidentService
        ){

    @Test
    @DisplayName("service 테스트")
    fun myAccidentServTest(){
        var lat = 35.8852F
        var lon = 128.61F
        val result = myAccidentService.getMyAccident(lat, lon)
        for (accidentArea in result) {
            println(accidentArea)
        }

    }
}