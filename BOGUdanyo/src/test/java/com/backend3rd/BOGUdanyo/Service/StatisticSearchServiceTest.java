package com.backend3rd.BOGUdanyo.Service;

import com.backend3rd.BOGUdanyo.AppConfig;
import com.backend3rd.BOGUdanyo.accidentArea.AccidentArea;
import com.backend3rd.BOGUdanyo.accidentArea.MemoryStatisticRepository;
import com.backend3rd.BOGUdanyo.accidentArea.StatisticRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StatisticSearchServiceTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /*@Test
    @DisplayName("메모리에 데이터 저장 테스트")
    void memoryRepoSearch(){
        StatisticSearchService sss = ac.getBean(StatisticSearchService.class);

        sss.addData("서울", 1f, 1f, 1, 3, 1, 1, 1);
        sss.addData("서울", 2f, 1f, 1, 5, 2, 1, 2);
        sss.addData("대구", 4f, 6f, 1, 7, 1, 3, 3);
        sss.addData("부산", 3f, 6f, 1, 4, 1, 1, 2);
        sss.addData("대구", 7f, 5f, 1, 6, 4, 1, 1);
        sss.addData("서울", 1f, 3f, 1, 2, 0, 1, 1);


        for (AccidentArea aa : sss.getRankedArea("서울")) {
            System.out.println("score = " + aa.calScore());
        }
    }*/
    
    @Test
    @DisplayName("DB에서 데이터 활용 테스트")
    void mySQLRepoSearch(){
        StatisticSearchService sss = ac.getBean(StatisticSearchService.class);
        
        for(AccidentArea aa : sss.getRankedArea("대구광역시 북구")){
            System.out.println("aa = " + aa + " score = " + aa.calScore());
        }
    }
}
