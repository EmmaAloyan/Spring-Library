package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreResponseDto extends GenreBaseDto{

    private Integer id;
    private String description;
}
