package com.example.springbootlibrary.service.impl;

import com.example.springbootlibrary.exception.UncorrectedRequestException;
import com.example.springbootlibrary.mapper.AuthorMapper;
import com.example.springbootlibrary.model.dto.AuthorRequestDto;
import com.example.springbootlibrary.model.dto.AuthorResponseDto;
import com.example.springbootlibrary.model.dto.AuthorUpdateDto;
import com.example.springbootlibrary.repo.AuthorRepo;
import com.example.springbootlibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;

    @Override
    @Transactional
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        var authorEntity = authorMapper.toAuthor(authorRequestDto);
        var save = authorRepo.save(authorEntity);
        return authorMapper.toAuthorResponseDto(save);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorResponseDto GetById(Integer id) {
        return authorMapper.toAuthorResponseDto(authorRepo.findById(id).orElseThrow(
                () -> new UncorrectedRequestException("request not found")));
    }

    @Override
    @Transactional
    public List<AuthorResponseDto> getAll() {
        var allAuthors = authorRepo.findAll();
        return allAuthors.stream().map(authorMapper::toAuthorResponseDto).toList();
    }

    @Override
    @Transactional
    public AuthorResponseDto update(AuthorUpdateDto authorUpdateDto) {
        var author = authorMapper.toAuthor(authorUpdateDto);
        return authorMapper.toAuthorResponseDto(authorRepo.save(author));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        authorRepo.deleteById(id);
    }
}
