package com.example.springpractice.dto;

import com.example.springpractice.entity.Position;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    Integer age;
    Long positionDto;
}
