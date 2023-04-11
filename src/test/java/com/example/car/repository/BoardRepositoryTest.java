package com.example.car.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.car.entity.Board;
import com.example.car.entity.Member;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1,20).forEach(i->{

            Member member = Member.builder().id("user"+i).build();

            Board board = Board.builder()
                    .title("Title"+i)
                    .content("Content"+i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        });
    }



}
