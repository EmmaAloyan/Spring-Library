package com.example.springbootlibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BookDetails implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private LocalDate publicationDate;
    private String isbm;
    private Integer price;
}
