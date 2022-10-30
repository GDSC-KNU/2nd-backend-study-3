package com.backend3rd.BOGUdanyo.service;

import org.json.simple.parser.ParseException;
import com.backend3rd.BOGUdanyo.api.KakaoRestApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BogudanyoService {

    KakaoRestApiHelper kakaoRestApiHelper;

    public float[][] findMyAccidentArea(String start, String goal) throws ParseException {
        float [] startC = kakaoRestApiHelper.getKakaoApiFromAddress(start);
        float [] goalC = kakaoRestApiHelper.getKakaoApiFromAddress(goal);

        return new float[][]{startC,goalC};
    }
}
