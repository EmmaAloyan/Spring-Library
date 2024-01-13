package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private LocalDate dateOfBirth;
    private String email;
}
