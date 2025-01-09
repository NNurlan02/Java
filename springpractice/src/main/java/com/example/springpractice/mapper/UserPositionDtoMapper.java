package com.example.springpractice.mapper;

import com.example.springpractice.dto.UserPositionDto;
import com.example.springpractice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserPositionDtoMapper {
    public UserPositionDto mapToDto(User user)
    {
        if (user==null){
            return null;
        }
        return new UserPositionDto(
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getPosition()!=null? user.getPosition().getPositionName():null,
                user.getPosition()!=null? user.getPosition().getSalary():null
        );
    }
}
