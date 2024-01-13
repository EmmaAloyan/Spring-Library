package com.example.springbootlibrary.mapper;

import com.example.springbootlibrary.model.dto.BookRequestDto;
import com.example.springbootlibrary.model.dto.BookResponseDto;
import com.example.springbootlibrary.model.entity.AuthorEntity;
import com.example.springbootlibrary.model.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toEntity (BookRequestDto bookRequestDto);

    String map(AuthorEntity authorEntity);

    BookResponseDto toBookResponseDto(BookEntity bookEntity);

    List<BookResponseDto> toResponseDtoList (List<BookEntity> bookEntities);
}
