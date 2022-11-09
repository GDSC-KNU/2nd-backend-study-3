package com.backend3rd.BOGUdanyo.api;

import com.backend3rd.BOGUdanyo.AppConfig;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KakaoRestApiHelperTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("카카오 api 테스트")
    void kakaoApiTest() throws ParseException {
        KakaoRestApiHelper bean = ac.getBean(KakaoRestApiHelper.class);
        float[] location = bean.getKakaoApiFromAddress("대구광역시 달서구 선원남로 181");
        System.out.println("input : 대구광역시 달서구 선원남로 181");
        System.out.println("test result : " + (location[0] == 128.52058F & location[1] == 35.857346F));
        System.out.println("longitude : " + location[0]);
        System.out.println("latitude : " + location[1]);
    }
}
