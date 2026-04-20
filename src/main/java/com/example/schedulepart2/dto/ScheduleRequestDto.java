package com.example.schedulepart2.dto;


import lombok.Getter;

@Getter // 모든 필드 getter 자동 생성
public class ScheduleRequestDto {
    // 사용자가 일정 생성/수정 요청할 때 보내는 데이터들
    private String username; // 작성자 유저명
    private String title; // 제목
    private String content; // 내용


}
