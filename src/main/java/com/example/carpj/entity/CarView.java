package com.example.carpj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cVNo;

    @ManyToOne(fetch = FetchType.LAZY) //명시적으로 Lazy 로딩 지정
    @OnDelete(action = OnDeleteAction.CASCADE) //회원 삭제되면 해당 포인트들도 삭제
    @JoinColumn(name = "cDNo")
    @JsonIgnore //저장 성공한 객체를 확인시키기 위한 JSON response에서 figure를 제외하고 보낸다.
    private CarDic modelNum; //carDic에서 어떤 모델인지 받아오기

    @ManyToOne(fetch = FetchType.LAZY) //명시적으로 Lazy 로딩 지정
    @OnDelete(action = OnDeleteAction.CASCADE) //회원 삭제되면 해당 포인트들도 삭제
    @JoinColumn(name = "cDNo")
    @JsonIgnore //저장 성공한 객체를 확인시키기 위한 JSON response에서 figure를 제외하고 보낸다.
    private Member id; //member 누구인지 받아오기
    
    private Integer count; //검색한 수
}
