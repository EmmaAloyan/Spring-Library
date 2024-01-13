package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookResponseDto extends BookBaseDto {

    private Integer id;
    private LocalDate publicationDate;
}
