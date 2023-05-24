package com.example.car.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(exclude={"id"})
@Table(name = "reply")
public class Reply extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno; // 댓글 번호
    @Column(length = 300, nullable = false)
    private String content; // 댓글 내용
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Member id; // 댓글 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_bno")
    private Board board; // 댓글이 작성된 게시글 번호
}
