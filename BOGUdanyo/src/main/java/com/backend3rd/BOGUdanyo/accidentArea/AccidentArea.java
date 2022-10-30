package com.backend3rd.BOGUdanyo.accidentArea;

import lombok.Getter;
import lombok.ToString;

@Getter // getter 생성
@ToString
public class AccidentArea implements Comparable<AccidentArea>{

        private String address; // 위치 정보
        private float lon; // 경도
        private float lat; // 위도
        private int occur_cnt; // 발생건수
        private int caslt_cnt; // 사상자 수
        private int death_cnt; // 사망자 수
        private int sever_cnt; // 중상자 수
        private int mild_cnt; // 경상자 수

        public AccidentArea(String address, float lon, float lat, int occur_cnt, int caslt_cnt, int death_cnt, int sever_cnt, int mild_cnt) {
                this.address = address;
                this.lon = lon;
                this.lat = lat;
                this.occur_cnt = occur_cnt;
                this.caslt_cnt = caslt_cnt;
                this.death_cnt = death_cnt;
                this.sever_cnt = sever_cnt;
                this.mild_cnt = mild_cnt;
        }

        public int calScore(){
                return this.death_cnt * 5 + this.sever_cnt * 3 + this.mild_cnt;
        }

        // 통계순으로 정렬
        @Override
        public int compareTo(AccidentArea aa) {
                int scoreA = this.calScore();
                int scoreB = aa.calScore();

                if(scoreA < scoreB) return 1;
                if(scoreA == scoreB) return 0;
                return -1;
        }
}
