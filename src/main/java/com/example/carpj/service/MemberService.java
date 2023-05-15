package com.example.carpj.service;

import com.example.carpj.dto.MemberDTO;
import com.example.carpj.entity.Member;

public interface MemberService {
    String memberSign(MemberDTO dto); //회원가입
    String memberLogin(String id, String pw); //로그인

    default Member dtoToEntity(MemberDTO dto) {
        Member member = Member.builder()
                .id(dto.getId())
                .pw(dto.getPw())
                .name(dto.getName())
                .nickname(dto.getNickname())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .detail_Address(dto.getDetail_Address())
                .location_Num(dto.getLocation_Num())
                .build();

        return member;
    }

    default MemberDTO entityToDTO(Member member) {
        MemberDTO dto = MemberDTO.builder()
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .nickname(member.getNickname())
                .phone(member.getPhone())
                .address(member.getAddress())
                .detail_Address(member.getDetail_Address())
                .location_Num(member.getLocation_Num())
                .build();
        return dto;
    }
}
