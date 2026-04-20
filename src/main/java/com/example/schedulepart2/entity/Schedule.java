package com.example.schedulepart2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // DB 테이블
@Getter // 모든 필드의 getter 자동 생성 (Lombok)
@NoArgsConstructor // 기본 생성자 자동 생성 (JPA 필수)
public class Schedule {

    @Id // 이 필드가 기본 키 (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;
    private String title;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자 : 새 일정 만들 때 사용한다
    public Schedule(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 일정 수정용 메서드: 값 새로 덮어씌움
    public void update(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

}
