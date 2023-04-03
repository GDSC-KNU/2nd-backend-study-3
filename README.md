# BOGUdanyo
BOGUdayo는 위치 정보와 공공데이터를 활용한 사고다발지역 안내 서비스이다.

## 1. 개요
현재 위치, 선택 경로, 선택 지역 등에 대하여 주변에 있는 사고다발지역에 대한 정보를 제공하는 서비스이다. 
공공데이터로 제공되는 사고다발지역정보을 DB에 저장하고, 사용자 요청에 따라 필터링 사고다발지역의 위치 및 상세 정보를 제공한다.

[도로교통공단 - 보행어린이사고다발지역정보 API](https://www.data.go.kr/data/15058925/openapi.do)

초기 개발은 Java를 기반으로 진행하였고, 이후 Kotlin과의 차이점을 파악하기 위해서 Kotlin으로 리팩토링하였다.

- [Java 기반 프로젝트](https://github.com/GDSC-KNU/2nd-study-backend-3/tree/master/BOGUdanyo)

- [Kotlin 기반 프로젝트](https://github.com/GDSC-KNU/2nd-study-backend-3/tree/master/BOGUdanyoKT)
## 2. 주요 기능 및 API 명세
#### [GET] myAccidentArea
- URL: /myAccidentArea

- Method: GET

- Parameter: start{String}, goal{String}

- Feature: 시작점과 도착점의 도로명 주소를 경도, 위도로 전환하여 사고다발지역 반환.

- Response Example:
```
{
    "documents": [
        {
            "address": {
                "address_name": "대구 북구 산격동 1370-1",
                "b_code": "2723011100",
                "h_code": "2723063000",
                "main_address_no": "1370",
                "mountain_yn": "N",
                "region_1depth_name": "대구",
                "region_2depth_name": "북구",
                "region_3depth_h_name": "산격3동",
                "region_3depth_name": "산격동",
                "sub_address_no": "1",
                "x": "128.614322336303",
                "y": "35.8890974884948"
            },
            "address_name": "대구 북구 대학로 80",
            "address_type": "ROAD_ADDR",
            "road_address": {
                "address_name": "대구 북구 대학로 80",
                "building_name": "경북대학교",
                "main_building_no": "80",
                "region_1depth_name": "대구",
                "region_2depth_name": "북구",
                "region_3depth_name": "산격동",
                "road_name": "대학로",
                "sub_building_no": "",
                "underground_yn": "N",
                "x": "128.614322336303",
                "y": "35.8890974884948",
                "zone_no": "41566"
            },
            "x": "128.614322336303",
            "y": "35.8890974884948"
        }
    ],
    "meta": {
        "is_end": true,
        "pageable_count": 1,
        "total_count": 1
    }
}
```
#### [GET] myAccidents
- URL: /myAccidents

- Method: GET

- Parameter: startLat{float}, startLon{float}

- Feature: 현재 위치(또는 지정한 하나의 지점)로부터 10km이내의 사고다발지역을 반환.

- Response Example:
```
[
    {
        "accidentId": 142412,
        "address": "대구광역시 북구 대현동(도원식품 부근)",
        "lat": 35.8852,
        "lon": 128.61
    },
    ...
]
```
#### [GET] statisticArea
- URL: /statisticArea

- Method: GET

- Parameter: region{String}

- Feature: 해당 지역내의 사고다발지역을 순위 별로 반환

- Response Example:
```
[
  {"id":6169266,
	"address":"서울특별시 강남구 도곡동(경남아파트 부근)",
	"lon":127.042,
	"lat":37.4879,
	"occur_cnt":4,
	"caslt_cnt":4,
	"death_cnt":0,
	"sever_cnt":4,
	"mild_cnt":0},
{"id":6100961,
	"address":"서울특별시 강남구 역삼동(한솔필리아 부근)",
	"lon":127.051,
	"lat":37.5013,
	"occur_cnt":3,
	"caslt_cnt":3,
	"death_cnt":0,
	"sever_cnt":1,
	"mild_cnt":2},
{"id":6395246,
	"address":"서울특별시 강남구 도곡동(언주초교 부근)",
	"lon":127.04,
	"lat":37.4867,
	"occur_cnt":3,
	"caslt_cnt":3,
	"death_cnt":0,
	"sever_cnt":1,
	"mild_cnt":2},
  ...
 ]
```
#### [GET] route
- URL: /route

- Method: GET

- Parameter: start{float}, goal{float}

- Feature: 시작점과 도착점 사이의 사고다발지역을 반환

- Response Example:
```
[
    {
        "accidentId": 142412,
        "address": "대구광역시 북구 대현동(도원식품 부근)",
        "lat": 35.8852,
        "lon": 128.61
    },
    {
        "accidentId": 142414,
        "address": "대구광역시 수성구 수성동4가(수성보성타운 부근)",
        "lat": 35.8637,
        "lon": 128.616
    },
    ...
]
```
## 3. 기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/KOTLIN-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">

<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/GCP-4285F4?style=for-the-badge&logo=Google Cloud&logoColor=white"> <img src="https://img.shields.io/badge/Kakao Map-FFCD00?style=for-the-badge&logo=Kakao&logoColor=white"> 
