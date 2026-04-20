package com.example.schedulepart2.service;

import com.example.schedulepart2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 비즈니스 로직 담당이다 -> 스프링이 자동으로 빈 (Bean) 등록
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입 (DI)
public class ScheduleService {

    // Repository를 주입받아서 DB 접근에 사용
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
}
