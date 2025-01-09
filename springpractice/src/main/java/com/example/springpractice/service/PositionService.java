package com.example.springpractice.service;

import com.example.springpractice.dto.PositionDto;
import com.example.springpractice.entity.Position;

import java.util.List;

public interface PositionService {
    List<PositionDto> findByAll();
    PositionDto findById(Long id);
    PositionDto savePosition(PositionDto positionDto);
    PositionDto updatePosition(PositionDto positionDto);
    void deletePosition(Long id);
}
