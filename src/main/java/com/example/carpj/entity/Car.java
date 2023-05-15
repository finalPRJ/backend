package com.example.carpj.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.time.Year;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;        // 번호 1,2,3~~~9999
    private String platform;   // 중고차 플랫폼 Ex. kb차차차, kcar
    private String tag;         // 국산 / 수입 태그
    private String type;        // 차종 Ex. suv, 경차, 대형차 등
    private String brand;       // 브랜드 Ex. 기아, 현대, 벤츠, BMW
    private String model;       // 풀 네임
    private String price;       // 가격  해당 중고차 화면에 표시할 가격
    private Integer pricer;     // 검색 기능 중 가격에 해당
    private Short year;        // 연식
    private String km;          // 주행거리
    private Integer kmr;        // 검색 기능 중 주행거리에 해당
    private String oil;     // 연료 타입
    private String region;      // 중고차 보관 센터 지역
    private String link;        // 해당 중고차 사이트 이동 링크
    private String img;         // 해당 중고차 이미지 링크
}
