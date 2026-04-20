package com.example.schedulepart2.controller;


import com.example.schedulepart2.dto.ScheduleRequestDto;
import com.example.schedulepart2.dto.ScheduleResponseDto;
import com.example.schedulepart2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST API 요청을 받는 컨트롤러이다 선언
@RequestMapping("/schedules") // 컨트롤러의 기본 URL 경로
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입 (DI)
public class ScheduleController {

    // Service를 주입받아서 비즈니스 로직 호출에 사용
    private final ScheduleService scheduleService;

    // 일정 생성 (POST /schedules)
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(@RequestBody ScheduleRequestDto dto) {
        // @RequestBody = 클라이언트가 보낸 JSON을 RequestDto로 변환
        return ResponseEntity.ok(scheduleService.createSchedule(dto));
    }

    // 일정 전체 조회 (GET /schedules)
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        return ResponseEntity.ok(scheduleService.findAll());
    }

    // 일정 단건 조회 (GET /schedules/{id})
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {


        // @PathVariable = URL에 있는 {id} 값을 가져옴
        return ResponseEntity.ok(scheduleService.findById(id));
    }

    // 일정 수정 (PUT /schedules/{id})
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, dto));
    }

    // 일정 삭제 (DELETE /schedules/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok().build();
    }
}



