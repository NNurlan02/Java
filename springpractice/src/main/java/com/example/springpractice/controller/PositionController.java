package com.example.springpractice.controller;

import com.example.springpractice.dto.PositionDto;
import com.example.springpractice.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
@AllArgsConstructor
public class PositionController {
    public final PositionService ser;
    @GetMapping
    public List<PositionDto> findByAll() {
        return ser.findByAll();
    }

    @GetMapping("/{id}")
    public PositionDto findById(@PathVariable Long id) {
        return ser.findById(id);
    }

    @PostMapping()
    public String savePosition(@RequestBody PositionDto positionDto) {
        ser.savePosition(positionDto);
        return "Position added";
    }


    @PutMapping()

    public String updatePosition(@RequestBody PositionDto positionDto) {
        ser.updatePosition(positionDto);
        return "Position updated";
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable Long id) {
        ser.deletePosition(id);
    }
}
