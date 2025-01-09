package com.example.springpractice.service;

import com.example.springpractice.dto.UserDto;
import com.example.springpractice.dto.UserPositionDto;
import com.example.springpractice.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
    UserPositionDto getUserPositionDto(User user);
    List<UserPositionDto> getAllUsersPosDto();

}
