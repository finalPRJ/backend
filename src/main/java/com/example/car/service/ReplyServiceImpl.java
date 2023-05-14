package com.example.car.service;

import com.example.car.entity.Member;
import com.example.car.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.car.dto.ReplyDTO;
import com.example.car.entity.Board;
import com.example.car.entity.Reply;
import com.example.car.repository.ReplyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Override
    public Integer register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        Board board = boardRepository.findById(replyDTO.getBno())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. bno=" + replyDTO.getBno()));
        reply.setBoard(boardRepository.save(board));
        replyRepository.save(reply);
        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Integer bno) {
        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(reply -> {
            Member member = reply.getReplyer(); // 댓글 작성자 정보 조회
            return entityToDTO(reply, member);
        }).collect(Collectors.toList());
        //return  result.stream().map(reply -> entityToDTO(reply, Member.builder().build())).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Integer rno = replyDTO.getRno();
        Reply reply = replyRepository.findById(rno).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. rno=" + rno));

        reply.setContent(replyDTO.getContent());

        Integer bno = replyDTO.getBno();
        Board board = boardRepository.findById(bno).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. bno=" + bno));
        reply.setBoard(board);

        replyRepository.save(reply);
    }

    @Override
    public void remove(Integer rno) {
        Reply reply = replyRepository.findById(rno).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. rno=" + rno));

        replyRepository.delete(reply);
    }

}
