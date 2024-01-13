package com.example.springbootlibrary.model.dto;

import com.example.springbootlibrary.util.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String userName;
    private String password;

    @NonNull
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dateOfBirth;

    private Gender gender;
}
