package com.example.springbootlibrary.service.impl;

import com.example.springbootlibrary.exception.BookNotFoundException;
import com.example.springbootlibrary.mapper.BookMapper;
import com.example.springbootlibrary.model.dto.*;
import com.example.springbootlibrary.model.entity.BookEntity;
import com.example.springbootlibrary.repo.BookRepo;
import com.example.springbootlibrary.service.BookService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;


    @Override
    @Transactional
    public BookResponseDto create(BookRequestDto bookRequestDto) {
        var bookEntity = bookMapper.toEntity(bookRequestDto);
        var save = bookRepo.save(bookEntity);
        return bookMapper.toBookResponseDto(save);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponseDto getById(Integer id) {
        return bookMapper.toBookResponseDto(bookRepo.findById(id).orElseThrow(
                () -> new BookNotFoundException("book not found")));
    }

    @Override
    @Transactional
    public List<BookResponseDto> getAll(PageRequest pageRequest) {
        Page<BookEntity> all = bookRepo.findAll(pageRequest);
        return all.stream().map(bookMapper::toBookResponseDto).toList();
    }

    @Override
    @Transactional
    public BookResponseDto update(Integer id, BookUpdateDto bookUpdateDto) {
        var excistingBookEntity = bookRepo.findById(id).orElseThrow(
                () -> new BookNotFoundException("book not found"));
        excistingBookEntity.setName(bookUpdateDto.getName());
        excistingBookEntity.setAuthor(bookUpdateDto.getAuthor());
        excistingBookEntity.setIsbm(bookUpdateDto.getIsbm());
        excistingBookEntity.setPrice(bookUpdateDto.getPrice());
        excistingBookEntity.setGenre(bookUpdateDto.getGenre());
        excistingBookEntity.setPublicationDate(bookUpdateDto.getPublicationDate());
        bookRepo.save(excistingBookEntity);
        return bookMapper.toBookResponseDto(excistingBookEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    @Transactional
    public List<BookResponseDto> filter(BookFilterDto bookFilterDto) {
        Specification<BookEntity> specification = Specification.where((root, criteriaQuery, criteriaBuilder) -> {
            var predicates = new ArrayList<jakarta.persistence.criteria.Predicate>();

            if (nonNull(bookFilterDto.getStartPrice())) {
                jakarta.persistence.criteria.Predicate startPrice = criteriaBuilder.greaterThan(root.get("price"), bookFilterDto.getStartPrice());
                predicates.add(startPrice);
            }
            if (nonNull(bookFilterDto.getEndPrice())) {
                jakarta.persistence.criteria.Predicate endPrice = criteriaBuilder.lessThan(root.get("price"), bookFilterDto.getEndPrice());
                predicates.add(endPrice);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
        return bookMapper.toResponseDtoList(bookRepo.findAll(specification));
    }
}
