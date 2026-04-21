package com.example.schedulepart2.service;


import com.example.schedulepart2.dto.UserRequestDto;
import com.example.schedulepart2.dto.UserResponseDto;
import com.example.schedulepart2.entity.User;
import com.example.schedulepart2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 비즈니스 로직 담당 -> 스프링이 자동으로 빈(Bean) 등록
@RequiredArgsConstructor // final 빌드 자동 생성자 주입 (DI)
public class UserService {

    // UserRepository 주입 받아서 DB 접근에 사용
    private final UserRepository userRepository;

    // 유저 생성
    public UserResponseDto createUser(UserRequestDto dto) {
        if (dto.getPassword().length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
        }

        // 1. RequestDto에서 값 꺼내서 Entity 생성
        User user = new User(dto.getUsername(), dto.getEmail(), dto.getPassword());

        // 2. DB에 저장
        User saved = userRepository.save(user);

        // 3. ResponseDto로 변환 후 반환
        return new UserResponseDto(saved);
    }

    // 유저 전체 조회
    public List<UserResponseDto> findAll() {

        // DB에서 모든 유저를 꺼냄 -> ResponseDto로 변환 -> 리스트로 반환
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .toList();
    }

    // 유저 단건 조회
    public UserResponseDto findById(Long id) {
        // ID로 유저찾고 ( 없으면 에러 )
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id=" + id));
        return new UserResponseDto(user);
    }

    // 유저 수정
    public UserResponseDto updateUser(Long id, UserRequestDto dto) {

        // 1. 수정 할 유저 찾기 ( 없으면 에러 )
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id=" + id));

        // 2. 값 변경
        user.update(dto.getUsername(), dto.getEmail(), dto.getPassword());

        // 3. DB에 저장 후 ResponseDto 반환
        User updated = userRepository.save(user);
        return new UserResponseDto(updated);
    }

    // 유저 삭제
    public void deleteUser(Long id) {
        // 해당 유저가 있는지 확인하고 없으면 에러
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 유저가 없습니다. id=" + id);
        }
        // DB에서 삭제
        userRepository.deleteById(id);
    }

    // 로그인
    public User login(String email, String password) {
        // 1. 이메일로 유저 찾기 (없으면 에러)
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일의 유저가 없습니다."));

        // 2. 비밀번호 확인 (틀리면 에러)
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        // 3. 로그인 성공 -> 유저 반환
        return user;
    }
}
