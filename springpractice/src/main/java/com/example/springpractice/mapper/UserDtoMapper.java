package com.example.springpractice.mapper;

import com.example.springpractice.dto.PositionDto;
import com.example.springpractice.dto.UserDto;
import com.example.springpractice.entity.Position;
import com.example.springpractice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserDto entityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getPosition() != null ? user.getPosition().getId() : null
        );
    }

    public User dtoToEntity(UserDto userDto) {
        Position position = new Position();
        position.setId(userDto.getPositionDto());

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());

        user.setPosition(position);
        return user;
    }

    public void updateDto(UserDto userDto, User user) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        if (userDto.getPositionDto() != null) {
            Position position = new Position();
            position.setId(userDto.getPositionDto());
            user.setPosition(position);
        }
    }

}
