package com.example.springpractice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Position {
    @Id
    @GeneratedValue
    Long id ;
    @Column
    String positionName;
    @Column
    BigDecimal salary;

}
