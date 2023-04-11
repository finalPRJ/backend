package com.example.car.service;

import com.example.car.dto.BoardDTO;
import com.example.car.dto.PageRequestDTO;
import com.example.car.dto.PageResultDTO;
import com.example.car.entity.Board;
import com.example.car.entity.Member;
public interface BoardService {
    // 게시글 작성 처리
    Integer register(BoardDTO dto);
    // 목록 처리
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder().id(dto.getWriterId()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .createtime(board.getCreatetime())
                .writerId(member.getId())
                .writerNickname(member.getNickname())
                .replyCount(replyCount.intValue())
                .build();
        return boardDTO;
    }
}
