package com.example.car.service;
import com.example.car.entity.Member;

public interface MemberService {
    boolean memberModify(Member member, String sex, Integer year); //회원 수정
}