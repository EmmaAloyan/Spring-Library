package com.example.springbootlibrary.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "genre")
public class GenreEntity extends BaseEntity {

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "description")
    private String description;
}
