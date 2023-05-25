package com.example.car.repository;

import com.example.car.dto.BoardDTO;
import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import com.example.car.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.car.entity.Board;
import com.example.car.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1,20).forEach(i->{

            Member member = Member.builder().id(2L).build();

            Board board = Board.builder()
                    .title("Title"+(i+520))
                    .content("Content"+(i+520))
                    .id(member)
                    .options1("")
                    .options2("")
                    .options3("")
                    .options4("")
                    .options5("")
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    @Transactional
    public void testRead1() {
        Optional<Board> result = boardRepository.findById(10);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getId());
    }

    @Test
    public void testReadWithWriter() {
        Object result = boardRepository.getBoardWithWriter(10);

        Object[] arr = (Object[])result;

        System.out.println("--------------------------------");
        System.out.println(Arrays.toString(arr));
    }

    @Test // 이 테스트 진행 시 LAZY -> EAGER로 바꿔야 실행 됨
    public void testGetBoardWithReply() {
        List<Object[]> result = boardRepository.getBoardWithReply(10);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testWithReplyCount() {
        Pageable pageable = PageRequest.of(0,20, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[])row;
            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void testRead3() {
        Object result = boardRepository.getBoardByBno(10);
        Object[] arr = (Object[])result;
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSearch1() {
        boardRepository.search1();
    }

    @Test
    public void testSearchPage() {
        Pageable pageable = PageRequest.of
                (0,40, Sort.by("bno").descending()
                        .and(Sort.by("title").ascending()));

        Page<Object[]> result = boardRepository.searchPage("title:20", pageable);
    }

}
