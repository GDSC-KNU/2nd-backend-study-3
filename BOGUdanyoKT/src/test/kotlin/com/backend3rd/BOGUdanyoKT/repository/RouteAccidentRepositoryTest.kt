package com.backend3rd.BOGUdanyoKT.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RouteAccidentRepositoryTest(
        @Autowired val routeAccidentRepository: RouteAccidentRepository
) {

    @Test
    @DisplayName("repository 테스트")
    fun routAccidentRepoTest(){
        var middleLat = 35.873222F
        var middleLon = 128.56744F
        var radius = 4576.597482105632
        val result = routeAccidentRepository.findByRegion(middleLat, middleLon, radius)
        for (accidentArea in result) {
            println(accidentArea.toString())
        }
    }
}