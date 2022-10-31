package com.backend3rd.BOGUdanyo.jpa;

import com.backend3rd.BOGUdanyo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JpaStatisticServiceTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Jpa 서비스 테스트")
    void jpaServiceTest(){
        JpaStatisticService bean = ac.getBean(JpaStatisticService.class);
        List<AccidentArea> rankedArea = bean.getRankedArea("대구광역시 달서구");
        for (AccidentArea accidentArea : rankedArea) {
            System.out.println("accidentArea = " + accidentArea.getAddress() + " score = " + accidentArea.calScore());
        }
    }
}
