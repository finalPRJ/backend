package com.example.car.service;

import com.example.car.entity.Member;
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

    @Override
    public Integer register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Integer bno) {
        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return  result.stream().map(reply -> entityToDTO(reply, Member.builder().build())).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
    }

    @Override
    public void remove(Integer rno) {
        replyRepository.deleteById(rno);
    }
}
