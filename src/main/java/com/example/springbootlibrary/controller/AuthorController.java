package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.model.dto.AuthorRequestDto;
import com.example.springbootlibrary.model.dto.AuthorResponseDto;
import com.example.springbootlibrary.model.dto.AuthorUpdateDto;
import com.example.springbootlibrary.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AuthorResponseDto> creat ( @RequestBody @Valid AuthorRequestDto authorRequestDto){
        var authorResponseDto = authorService.create(authorRequestDto);
        return ResponseEntity.ok(authorResponseDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<AuthorResponseDto> getById(@PathVariable @Positive Integer id){
        return new ResponseEntity<>(authorService.GetById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<AuthorResponseDto>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<AuthorResponseDto> update (@RequestBody AuthorUpdateDto authorUpdateDto){
        return new ResponseEntity<>(authorService.update(authorUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Void> delete(@PathVariable Integer id){
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
