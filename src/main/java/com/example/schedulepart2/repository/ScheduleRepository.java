package com.example.schedulepart2.repository;

import com.example.schedulepart2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 아래 기능 생성
    // save() -> 저장
    // findAll() -> 전체 조회
    // findById() -> 단건 조회
    // deleteById() -> 삭제
}
