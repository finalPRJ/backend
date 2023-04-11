package com.example.car.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Integer bno; // 게시글 번호
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String writerId; // 작성자 id
    private String writerNickname; // 작성자 nickname
    private LocalDateTime createtime; // 생성날짜
    private int replyCount; // 해당 게시글의 댓글 수
}
