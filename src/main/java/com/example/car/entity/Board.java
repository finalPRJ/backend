package com.example.car.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Table(name = "board")
public class Board extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno; // 게시물 번호
    @Column(length = 300, nullable = false)
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer; // 게시글 작성자
}
