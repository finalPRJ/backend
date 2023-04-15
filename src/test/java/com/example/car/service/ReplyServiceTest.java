package com.example.car.service;

import com.example.car.entity.Reply;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.car.dto.ReplyDTO;

import java.util.List;

@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    private ReplyService service;

    @Test
    public void testGetList() {
        Integer bno = 8;
        List<ReplyDTO> replyDTOList = service.getList(bno);
        replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
    }

}
