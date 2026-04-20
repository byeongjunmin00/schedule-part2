package com.example.schedulepart2.service;

import com.example.schedulepart2.dto.ScheduleRequestDto;
import com.example.schedulepart2.dto.ScheduleResponseDto;
import com.example.schedulepart2.entity.Schedule;
import com.example.schedulepart2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 비즈니스 로직 담당이다 -> 스프링이 자동으로 빈 (Bean) 등록
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입 (DI)
public class ScheduleService {

    // Repository를 주입받아서 DB 접근에 사용
    private final ScheduleRepository scheduleRepository;

    // 일정
    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
        // 1. RequestDto에서 값을 꺼내서 Entity 생성
        Schedule schedule = new Schedule(dto.getUsername(), dto.getTitle(), dto.getContent());

        // 2. Repository를 통해 DB에 저장
        Schedule saved = scheduleRepository.save(schedule);

        // 3. 저장된 Entity를 ResponseDto로 변환 후 반환
        return new ScheduleResponseDto(saved);
    }

    // 일정 전체 조회
    public List<ScheduleResponseDto> findAll() {
        // DB에서 모든 일정을 꺼내서 -> 하나씩 ResponseDto로 변환 -> 리스트로 반환

        return scheduleRepository.findAll()
                .stream() // 리스트를 하나씩 꺼냄
                .map(ScheduleResponseDto::new) // 각각 ResponseDto로 변환
                .toList(); // 다시 리스트로 모음
    }

    // 일정 단건 조회
    public ScheduleResponseDto findById(Long id) {
        // ID로 일정 찾고 없으면 에러 발생
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다. id =" + id));
        // Entity를 ResponseDto로 변환 후 반환
        return new ScheduleResponseDto(schedule);
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto dto) {

        // 1. 수정할 일정을 ID로 찾기 (없으면 에러)
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다. id =" + id));
        // 2. Entity의 값 새로운 값으로 변경
        schedule.update(dto.getUsername(), dto.getTitle(), dto.getContent());

        // 3. 변경된 Entity를 다시 DB에 저장
        Schedule updated = scheduleRepository.save(schedule);

        // 4. ResponseDto로 변환 후 반환
        return new ScheduleResponseDto(updated);
    }

    // 일정 삭제
    public void deleteSchedule(Long id) {
        // 해당 ID의 일정이 있는지 확인 ( 없으면 에러 )
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 일정이 없습니다. id =" + id);
        }

        // DB에서 삭제
        scheduleRepository.deleteById(id);
     }

}
