package com.example.carpj.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "board")
public class Board extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno; // 게시물 번호
    @Column(length = 300, nullable = false)
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer; // 게시글 작성자
    private String options1; // 외장 옵션
    private String options2; // 내장 옵션
    private String options3; // 안전 옵션
    private String options4; // 편의 옵션
    private String options5; // 멀티 옵션

    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeContent(String content) {
        this.content = content;
    }
    public void changeOptions1(String options1) {
        this.options1 = options1;
    }
    public void changeOptions2(String options2) {
        this.options2 = options2;
    }
    public void changeOptions3(String options3) {
        this.options3 = options3;
    }
    public void changeOptions4(String options4) {
        this.options4 = options4;
    }
    public void changeOptions5(String options5) {
        this.options5 = options5;
    }
}
