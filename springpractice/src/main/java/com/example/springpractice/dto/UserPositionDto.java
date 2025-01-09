package com.example.springpractice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.logging.Level;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPositionDto {
    String firstName;
    String lastName;
    Integer age;
    String positionName;
    BigDecimal salary;
}
