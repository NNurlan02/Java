package com.example.springpractice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="users")
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    Integer age;
    @ManyToOne
    @JoinColumn(name = "position_id")
    Position position;
}
