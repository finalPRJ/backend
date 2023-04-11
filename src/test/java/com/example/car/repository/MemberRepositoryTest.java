package com.example.car.repository;

import com.example.car.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.car.entity.Member;

import java.util.stream.IntStream;
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1,20).forEach(i->{
            Member member = Member.builder()
                    .id("user"+i)
                    .pw("1111")
                    .name("강태영")
                    .nickname("UUSS"+i)
                    .phone("010-3919-9456")
                    .address("서울")
                    .detail_Address("강남")
                    .location_Num("556-112")
                    .age(25)
                    .platform("네이버")
                    .role(Role.USER)
                    .build();
            memberRepository.save(member);
        });
    }
}
