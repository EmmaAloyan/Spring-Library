package com.example.springbootlibrary.mapper;

import com.example.springbootlibrary.model.dto.AuthorRequestDto;
import com.example.springbootlibrary.model.dto.AuthorResponseDto;
import com.example.springbootlibrary.model.dto.AuthorUpdateDto;
import com.example.springbootlibrary.model.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorEntity toAuthor(AuthorRequestDto authorRequestDto);
    AuthorEntity toAuthor(AuthorUpdateDto authorUpdateDto);

    AuthorResponseDto toAuthorResponseDto(AuthorEntity authorEntity);
}
