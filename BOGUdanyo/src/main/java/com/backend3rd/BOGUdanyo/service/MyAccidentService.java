package com.backend3rd.BOGUdanyo.service;

import com.backend3rd.BOGUdanyo.api.KakaoRestApiHelper;
import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import com.backend3rd.BOGUdanyo.repository.MyAccidentRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource(value={"classpath:application.properties"})
@RequiredArgsConstructor
public class MyAccidentService {

    final KakaoRestApiHelper kakaoRestApiHelper;
    final MyAccidentRepository myAccidentRepository;

    public List<AccidentArea> getMyAccident(String start) throws ParseException {
        float [] startC = kakaoRestApiHelper.getKakaoApiFromAddress(start);
        float startLon = startC[0];
        float startLat = startC[1];

        List<AccidentArea> result = myAccidentRepository.findByRegion(startLon, startLat);

        return result;
    }


}
