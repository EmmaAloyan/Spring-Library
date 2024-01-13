package com.example.springbootlibrary.model.dto;

import com.example.springbootlibrary.model.entity.AuthorEntity;
import com.example.springbootlibrary.model.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookBaseDto {

    private String name;
    private AuthorEntity author;
    private LocalDate publicationDate;
    private GenreEntity genre;
    private String isbm;
    private Integer price;

}
