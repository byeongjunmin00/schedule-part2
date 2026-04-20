package com.example.schedulepart2.repository;

import com.example.schedulepart2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
