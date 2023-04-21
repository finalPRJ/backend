package com.example.car.service;

import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.car.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Test")
                .content("Test 새로운 데이터")
                .writerId("user20")
                .build();
        Integer bno = boardService.register(dto);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testGet() {
        Integer bno = 8;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    // 삭제 처리 테스트 진행 안함
    @Test
    public void testRemove() {
        Integer bno =21;
        boardService.removeWithReplies(bno);
    }



    @Test
    public void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(21)
                .title("수정")
                .content("수정한 데이터")
                .build();

        boardService.modify(boardDTO);
    }
}
