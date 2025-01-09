package com.example.springpractice.controller;

import com.example.springpractice.dto.UserDto;
import com.example.springpractice.dto.UserPositionDto;
import com.example.springpractice.entity.User;
import com.example.springpractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/all-users")
    public List<UserPositionDto> getAllUsersPosDto() {
        return service.getAllUsersPosDto();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public String saveUsers(@RequestBody UserDto userDto) {
        service.saveUser(userDto);
        return "Users added";
    }

    @PutMapping()
    public String updateUser(@RequestBody UserDto userDto) {
        service.updateUser(userDto);
        return "Users updated";
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

}
