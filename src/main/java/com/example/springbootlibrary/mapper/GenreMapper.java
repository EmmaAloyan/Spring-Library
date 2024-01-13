package com.example.springbootlibrary.mapper;

import com.example.springbootlibrary.model.dto.GenreRequestDto;
import com.example.springbootlibrary.model.dto.GenreResponseDto;
import com.example.springbootlibrary.model.entity.GenreEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreEntity toEntity (GenreRequestDto genreRequestDto);

    GenreResponseDto toResponseDto(GenreEntity genreEntity);

    List<GenreResponseDto> toResponseDtoList(List<GenreEntity> genreEntities);
}
