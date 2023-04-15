package com.example.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
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
