package com.example.springpractice.repository;

import com.example.springpractice.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
  void deleteById(Long id);
}
