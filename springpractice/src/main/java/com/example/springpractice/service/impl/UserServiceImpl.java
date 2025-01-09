package com.example.springpractice.service.impl;

import com.example.springpractice.dto.UserDto;
import com.example.springpractice.dto.UserPositionDto;
import com.example.springpractice.exceptions.CustomException;
import com.example.springpractice.mapper.UserDtoMapper;
import com.example.springpractice.mapper.UserPositionDtoMapper;
import com.example.springpractice.service.UserService;
import com.example.springpractice.entity.User;
import com.example.springpractice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final UserPositionDtoMapper userPositionDtoMapper;
    private final UserDtoMapper usmp;

    @Override
    public List<UserDto> findAll() {
        List<User> users = repo.findAll();
        return users.stream()
                .map(usmp::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> userOptional = repo.findById(id);
        if(userOptional.isPresent())
        {
            User user = userOptional.get();
            return usmp.entityToDto(user);
        }
        else{
            throw new CustomException("User not found with  id:"+id);
        }
    }


    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = usmp.dtoToEntity(userDto);
        User saveUser = repo.save(user);
        return usmp.entityToDto(saveUser);
    }


    @Override
    public UserDto updateUser(UserDto userDto) {
       User user = repo.findById(userDto.getId()).orElseThrow(()->new RuntimeException("User not found"));
        usmp.updateDto(userDto, user);
        User updateUser = repo.save(user);
        return usmp.entityToDto(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    @Override
    public UserPositionDto getUserPositionDto(User user) {
        return  userPositionDtoMapper.mapToDto(user);
    }

    @Override
    public List<UserPositionDto> getAllUsersPosDto() {
        List<User> users = repo.findAll();
        return users.stream()
                .map(userPositionDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
