package com.example.springbootlibrary.service;

import com.example.springbootlibrary.model.dto.GenreRequestDto;
import com.example.springbootlibrary.model.dto.GenreResponseDto;
import com.example.springbootlibrary.model.dto.GenreUpdateDto;

import java.util.List;

public interface GenreService {

    GenreResponseDto create(GenreRequestDto genreRequestDto);

    GenreResponseDto getById(Integer id);

    List<GenreResponseDto> getAll();

    void delete(Integer id);

    GenreResponseDto update(Integer id, GenreUpdateDto genreUpdateDto);
}
