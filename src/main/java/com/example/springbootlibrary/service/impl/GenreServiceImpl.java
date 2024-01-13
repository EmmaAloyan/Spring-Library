package com.example.springbootlibrary.service.impl;

import com.example.springbootlibrary.exception.UncorrectedRequestException;
import com.example.springbootlibrary.mapper.GenreMapper;
import com.example.springbootlibrary.model.dto.GenreRequestDto;
import com.example.springbootlibrary.model.dto.GenreResponseDto;
import com.example.springbootlibrary.model.dto.GenreUpdateDto;
import com.example.springbootlibrary.model.entity.GenreEntity;
import com.example.springbootlibrary.repo.GenreRepo;
import com.example.springbootlibrary.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Component
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;
    private final GenreMapper genreMapper;


    @Override
    @Transactional
    public GenreResponseDto create(GenreRequestDto genreRequestDto) {
        var genreEntity = genreMapper.toEntity(genreRequestDto);
        var save = genreRepo.save(genreEntity);
        return genreMapper.toResponseDto(save);
    }

    @Override
    @Transactional
    public GenreResponseDto getById(Integer id) {
        return genreMapper.toResponseDto(genreRepo.findById(id).orElseThrow(
                () -> new UncorrectedRequestException("request not found")));
    }

    @Override
    @Transactional
    public List<GenreResponseDto> getAll() {
        var allGenres = genreRepo.findAll();
        return allGenres.stream().map(genreMapper::toResponseDto).toList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        genreRepo.deleteById(id);
    }

    @Override
    @Transactional
    public GenreResponseDto update(Integer id, GenreUpdateDto genreUpdateDto) {
        GenreEntity excistingGenreEntity = genreRepo.findById(id).orElseThrow(
                () -> new UncorrectedRequestException("request not found"));
        excistingGenreEntity.setGenreName(genreUpdateDto.getGenreName());
        excistingGenreEntity.setDescription(genreUpdateDto.getDescription());

        genreRepo.save(excistingGenreEntity);
        return genreMapper.toResponseDto(excistingGenreEntity);
    }
}
