package com.example.schedulepart2.dto;


import com.example.schedulepart2.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String createdAt;
    private String updatedAt;

    // Entity -> DTO 변환 생성자
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt().toString();
        this.updatedAt = user.getUpdatedAt().toString();
    }
}
