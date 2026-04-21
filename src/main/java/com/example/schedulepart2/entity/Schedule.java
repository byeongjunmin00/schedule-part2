package com.example.schedulepart2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // DB 테이블
@Getter // 모든 필드의 getter 자동 생성 (Lombok)
@NoArgsConstructor // 기본 생성자 자동 생성 ( JPA 필수 )
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 사용
public class Schedule {

    @Id // 기본 키 (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가

    private Long id;

    // 일정을 작성한 유저 (N:1 관계 - 일정 여러 개가 유저 1명에 연결)
    @ManyToOne
    @JoinColumn(name = "user_id") // DB에 user_id 컬럼으로 저장
    private User user;

    private String title;
    private String content;

    @CreatedDate // 생성 시 자동 시간 기록
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시 자동 시간 갱신
    private LocalDateTime updatedAt;

    // 생성자 : 새 일정 만들 때 사용한다
    public Schedule(User user, String title, String content) {
        this.user = user; // username 대신 User 객체를 받음
        this.title = title;
        this.content = content;
        // createdAt, updatedAt는 JPA Auditing가 자동으로 넣기 때문에 삭제
    }

    // 일정 수정용 메서드: 값 새로 덮어씌움
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        // 작성자(user)는 수정 안 함! 제목/내용만 변경한다
        // updatedAt는 JPA Auditing가 자동 갱신하기에 삭제
    }
}
