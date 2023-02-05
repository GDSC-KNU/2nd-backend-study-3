package com.backend3rd.BOGUdanyoKT.service

import com.backend3rd.BOGUdanyoKT.dto.MyAccidentDto
import com.backend3rd.BOGUdanyoKT.entity.AccidentArea
import com.backend3rd.BOGUdanyoKT.repository.MyAccidentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MyAccidentService (
        @Autowired val myAccidentRepository: MyAccidentRepository
){

    fun getMyAccident(startLat: Float, startLon: Float): List<AccidentArea>{
        return myAccidentRepository.findByRegion(startLat, startLon)
    }
}