package com.example.schedulepart2.controller;


import com.example.schedulepart2.dto.UserRequestDto;
import com.example.schedulepart2.dto.UserResponseDto;
import com.example.schedulepart2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST API 요청 받는 컨트롤러
@RequestMapping("/users") // 기본 URL 경로
@RequiredArgsConstructor // final 필드 자동 생성자 주입
public class UserController {

    // UserService 주입 받아서 비즈니스 로직 호출에 사용
    private final UserService userService;

    // 유저 생성 (POST /users)
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // 유저 전체 조회 (GET /users)
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findaAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    // 유저 단건 조회 (GET /users/{id})
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    // 유저 수정 (PUT /users/{id})
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    // 유저 삭제 (DELETE /users/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
