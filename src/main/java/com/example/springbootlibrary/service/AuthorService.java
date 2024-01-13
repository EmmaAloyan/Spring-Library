package com.example.springbootlibrary.service;

import com.example.springbootlibrary.model.dto.AuthorRequestDto;
import com.example.springbootlibrary.model.dto.AuthorResponseDto;
import com.example.springbootlibrary.model.dto.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {

    AuthorResponseDto create (AuthorRequestDto authorRequestDto);

    AuthorResponseDto GetById (Integer id);

    List<AuthorResponseDto> getAll();

    AuthorResponseDto update(AuthorUpdateDto authorUpdateDto);

    void delete (Integer id);
}
