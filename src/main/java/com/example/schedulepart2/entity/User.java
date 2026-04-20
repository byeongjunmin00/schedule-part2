package com.example.schedulepart2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // DB 테이블과 매핑
@Getter // 모든 필드의 getter 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성 (JPA 필수)
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 사용하겠다
public class User {

    @Id // 기본 키 (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long id;

    private String username;
    private String email;

    @CreatedDate // 생성 시 자동으로 시간 기록
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시 자동으로 시간 갱신
    private LocalDateTime updatedAt;

    // 생성자 : 새 유저 만들 때 사용
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        // createdAt, updatedAt는 JPA Auditing가 자동으로 넣어준다
    }

    // 유저 수정용 메서드
    public void update(String username, String email) {
        this.username = username;
        this.email = email;
        // updatedAt는 JPA Auditing가 자동으로 갱신 해준다
    }
}
