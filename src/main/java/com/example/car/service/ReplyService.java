package com.example.car.service;

import com.example.car.dto.ReplyDTO;
import com.example.car.entity.Board;
import com.example.car.entity.Member;
import com.example.car.entity.Reply;
import java.util.List;

public interface ReplyService {
    // 댓글 등록
    Integer register(ReplyDTO replyDTO);
    // 게시물 댓글 목록
    List<ReplyDTO> getList(Integer bno);
    // 댓글 수정
    void modify(ReplyDTO replyDTO);
    // 댓글 삭제
    void remove(Integer rno);

    default Reply dtoToEntity(ReplyDTO replyDTO) {
        Board board = Board.builder().bno(replyDTO.getBno()).build();
        Member member = Member.builder().id(replyDTO.getReplyerId()).build();

        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .content(replyDTO.getContent())
                .replyer(member)
                .board(board)
                .build();

        return reply;
    }

    default ReplyDTO entityToDTO(Reply reply, Member member) {
        ReplyDTO dto = ReplyDTO.builder()
                .rno(reply.getRno())
                .content(reply.getContent())
                .replyerId(reply.getReplyer().getId())
                .replyerNickname(reply.getReplyer().getNickname())
                .bno(reply.getBoard().getBno())
                .createtime(reply.getCreatetime())
                .build();

        return dto;
    }
}
