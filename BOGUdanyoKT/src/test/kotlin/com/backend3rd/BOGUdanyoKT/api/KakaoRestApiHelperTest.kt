package com.backend3rd.BOGUdanyoKT.api

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KakaoRestApiHelperTest(
        @Autowired val kakaoRestApiHelper: KakaoRestApiHelper
) {

    @Test
    @DisplayName("카카오 api 테스트")
    fun kakaoApiTest(){
        val location = kakaoRestApiHelper.getKakaoApiFromAddress("대구광역시 북구 대학로 80")
        assertThat(location[0]).isEqualTo(128.61432F)
        assertThat(location[1]).isEqualTo(35.8891F)
        println("lon: "+ location[0] + " lat: " + location[1])
    }
}