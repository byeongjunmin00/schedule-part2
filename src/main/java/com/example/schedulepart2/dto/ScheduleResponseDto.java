package com.example.schedulepart2.dto;

import com.example.schedulepart2.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    // 서버가 클라이언트에게 돌려주는 데이터 (일정 조회 결과)
    private Long id; // 일정 고유 ID
    private String username; // 작성자 유저명
    private String title; // 제목
    private String content; // 내용
    private String createdAt; // 작성일
    private String updatedAt; // 수정일

    // Entity -> DTO 변환 생성자 (Entity를 직접 노출하지않고 사본 만들기)
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt().toString();
        this.updatedAt = schedule.getUpdateAt().toString();
    }
}
