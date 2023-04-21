package com.example.car.dto;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDTO {
    private Integer rno;
    private String content;
    private String replyerId;
    private String replyerNickname;
    private Integer bno;
    private LocalDateTime createtime;
}
