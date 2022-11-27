package com.backend3rd.BOGUdanyoKT.service

import com.backend3rd.BOGUdanyoKT.api.KakaoRestApiHelper
import com.backend3rd.BOGUdanyoKT.entity.AccidentArea
import com.backend3rd.BOGUdanyoKT.repository.RouteAccidentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

@Service
class RouteAccidentService (
        @Autowired val kakaoRestApiHelper: KakaoRestApiHelper,
        @Autowired val routeAccidentRepository: RouteAccidentRepository
        ) {

        fun getRoutAccident(
                start: String, goal: String): List<AccidentArea> {
                var startC = kakaoRestApiHelper.getKakaoApiFromAddress(start)
                var goalC = kakaoRestApiHelper.getKakaoApiFromAddress(goal)

                var middleLat = (startC[1] + goalC[1]) / 2
                var middleLon = (startC[0] + goalC[0]) / 2

                var radius = distance(middleLat, middleLon, startC[1], startC[0])

                return routeAccidentRepository.findByRegion(middleLat, middleLon, radius)
        }

        fun distance(lat1: Float, lon1: Float, lat2: Float, lon2: Float): Double{
                var lat1d = lat1.toDouble()
                var lon1d = lon1.toDouble()
                var lat2d = lat2.toDouble()
                var lon2d = lon2.toDouble()

                var theta = lon1d - lon2d
                var dist = (sin(deg2rad(lat1d)) * sin(deg2rad(lat2d)) + cos(deg2rad(lat1d)) * cos(deg2rad(lat2d)) * cos(deg2rad(theta)))
                dist = acos(dist)
                dist = rad2deg(dist)
                dist *= 60 * 1.1515 * 1609.344

                return dist
        }

        fun deg2rad(deg: Double): Double{ return deg * PI / 180.0}

        fun rad2deg(rad: Double): Double{ return rad * 180 / PI}
}