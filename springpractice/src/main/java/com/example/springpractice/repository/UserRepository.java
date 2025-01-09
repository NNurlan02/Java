package com.example.springpractice.repository;

import com.example.springpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);

}
