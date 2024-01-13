package com.example.springbootlibrary.service;

import com.example.springbootlibrary.model.dto.BookFilterDto;
import com.example.springbootlibrary.model.dto.BookRequestDto;
import com.example.springbootlibrary.model.dto.BookResponseDto;
import com.example.springbootlibrary.model.dto.BookUpdateDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {

    BookResponseDto create (BookRequestDto bookRequestDto);

    BookResponseDto getById (Integer id);

    List<BookResponseDto> getAll (PageRequest pageRequest);


    BookResponseDto update(Integer id, BookUpdateDto bookUpdateDto);
    void delete (Integer id);

    List<BookResponseDto> filter(BookFilterDto bookFilterDto);


}
