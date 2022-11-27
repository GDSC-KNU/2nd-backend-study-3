package com.backend3rd.BOGUdanyoKT.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MyAccidentRepoTest (
        @Autowired val myAccidentRepository: MyAccidentRepository
        ){

    @Test
    @DisplayName("repository 테스트")
    fun myAccidentRepoTest(){
        var lat = 35.8852F
        var lon = 128.61F

        val result = myAccidentRepository.findByRegion(lat, lon)
        //val result = myAccidentRepository.findAll()
        if(result != null){
            for (accidentArea in result) {
                println(accidentArea.toString())
            }
        }
    }

}