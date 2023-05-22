package com.example.car.repository;

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

                    .build();
            memberRepository.save(member);
        });
    }
}
