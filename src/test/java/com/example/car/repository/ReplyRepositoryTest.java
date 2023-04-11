package com.example.car.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.car.entity.Board;
import com.example.car.entity.Member;
import com.example.car.entity.Reply;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;
@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply() {
        IntStream.rangeClosed(1,20).forEach(i->{
            Integer bno = (int)(Math.random()*10)+1;

            Board board = Board.builder().bno(bno).build();
            Member member = Member.builder().id("user"+i).build();

            Reply reply = Reply.builder()
                    .content("Reply"+i)
                    .board(board)
                    .replyer(member)
                    .build();
            replyRepository.save(reply);
        });
    }

    @Test
    @Transactional
    public void readReply1() {
        Optional<Reply> result = replyRepository.findById(7);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }

}
