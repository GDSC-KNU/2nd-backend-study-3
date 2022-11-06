package com.backend3rd.BOGUdanyo.service;

import com.backend3rd.BOGUdanyo.api.KakaoRestApiHelper;
import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.repository.RouteAccidentRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource(value={"classpath:application.properties"})
@RequiredArgsConstructor
public class RouteAccidentService {
    final KakaoRestApiHelper kakaoRestApiHelper;

    final RouteAccidentRepository accidentRouteRepository;

    public List<AccidentArea> getRouteAccident(String start, String goal) throws ParseException {
        float [] startC = kakaoRestApiHelper.getKakaoApiFromAddress(start);
        float [] goalC = kakaoRestApiHelper.getKakaoApiFromAddress(goal);

        float middleLon = (startC[0] + goalC[0])/2;
        float middleLat = (startC[1] + goalC[1])/2;

        double radius = distance(middleLat, middleLon, startC[1], startC[0]);

        List<AccidentArea> result = accidentRouteRepository.findByRegion(middleLat, middleLon, radius);

        return result;
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2){
        double theta = lon1 - lon2;
        double dist = (Math.sin(deg2rad(lat1))* Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.cos(deg2rad(theta)));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344;

        return dist; //단위 meter
    }

    //10진수를 radian(라디안)으로 변환
    private static double deg2rad(double deg){
        return deg * Math.PI/180.0;
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return rad * 180 / Math.PI;
    }
}
