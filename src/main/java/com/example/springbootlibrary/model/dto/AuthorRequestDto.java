package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequestDto extends AuthorBaseDto{

    private String firstName;
    private String lastName;

}
