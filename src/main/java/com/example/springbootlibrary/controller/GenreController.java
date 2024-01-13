package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.model.dto.GenreRequestDto;
import com.example.springbootlibrary.model.dto.GenreResponseDto;
import com.example.springbootlibrary.model.dto.GenreUpdateDto;
import com.example.springbootlibrary.service.GenreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/genres")
public class GenreController {

    private final GenreService genreService;


    @PostMapping
    public ResponseEntity<GenreResponseDto> create (@RequestBody @Valid GenreRequestDto genreRequestDto){
        var genreResponseDto = genreService.create(genreRequestDto);
        return ResponseEntity.ok(genreResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> getById(@PathVariable @Positive Integer id){
        var genreById = genreService.getById(id);
        return ResponseEntity.ok(genreById);
    }

    @GetMapping("/all")
    ResponseEntity<List<GenreResponseDto>> getAll() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Integer id){
        genreService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity<GenreResponseDto> update (@RequestBody Integer id, GenreUpdateDto genreUpdateDto){
        return new ResponseEntity<>(genreService.update(id,genreUpdateDto),HttpStatus.OK);
    }

}
