package com.example.car.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor //필드 값을 다 넣은 생성자
@NoArgsConstructor //기본 생성자
@Table(name = "member")
public class Member {
    @Id
    private String id; //아이디(이메일)

    @Column(length = 300, nullable = false)
    private String pw; //패스워드

    private String name; //이름

    private String nickname; //닉네임

    private String phone; //전화번호

    private String address; //주소

    private String detail_Address; //상세 주소

    private String location_Num; //우편번호

    private Integer age; //나이

    private String platform; //토큰

    @Enumerated(EnumType.STRING)
    private Role role;
}