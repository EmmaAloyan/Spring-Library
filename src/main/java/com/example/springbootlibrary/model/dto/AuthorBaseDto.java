package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBaseDto {

    private String firstName;
    private String lastName;
    private String nationality;
    private String birthdate;
}
