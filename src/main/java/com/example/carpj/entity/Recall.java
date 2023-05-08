package com.example.carpj.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor //필드 값을 다 넣은 생성자
@NoArgsConstructor //기본 생성자
@Table(name = "recall")
public class Recall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rNo; //리콜 번호

    @Column(length = 300, nullable = false)
    private String brand; //리콜된 브랜드

    @Column(length = 100)
    private String model; //리콜된 차명

    @Column(length = 1000)
    private String reasons; //리콜 사유

    @Column(length = 50, nullable = false)
    private String ranking; //리콜 순위

    private Integer amount; //리콜 개시된 대수
}