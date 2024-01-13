package com.example.springbootlibrary.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequestDto extends BookBaseDto {

    @NotNull
    private LocalDate publicationDate;

}
