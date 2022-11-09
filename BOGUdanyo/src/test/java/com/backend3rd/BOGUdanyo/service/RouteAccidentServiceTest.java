package com.backend3rd.BOGUdanyo.service;

import com.backend3rd.BOGUdanyo.AppConfig;
import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RouteAccidentServiceTest {

//    @Autowired
//    RouteAccidentService routeAccidentService;

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("routeAccident 서비스 테스트")
    void RouteAccidentServiceTest() throws ParseException {
        RouteAccidentService bean = ac.getBean(RouteAccidentService.class);
        List<AccidentArea> rankedArea = bean.getRouteAccident("대구광역시 달서구 선원남로 181", "대구광역시 북구 대학로 80");
        for (AccidentArea accidentArea : rankedArea) {
            System.out.println("accidentArea = " + accidentArea.getAddress() + " score = " + accidentArea.calScore());
        }
    }
}
