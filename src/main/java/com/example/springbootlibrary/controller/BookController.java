package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.model.dto.BookFilterDto;
import com.example.springbootlibrary.model.dto.BookRequestDto;
import com.example.springbootlibrary.model.dto.BookResponseDto;
import com.example.springbootlibrary.model.dto.BookUpdateDto;
import com.example.springbootlibrary.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> creat ( @RequestBody @Valid BookRequestDto bookRequestDto){
        var bookResponseDto = bookService.create(bookRequestDto);
        return ResponseEntity.ok(bookResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById( @PathVariable @Positive Integer id){
        var bookById = bookService.getById(id);
        return ResponseEntity.ok(bookById);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll (@RequestParam( defaultValue = "0") Integer page,
                                                         @RequestParam( defaultValue = "20") Integer size,
                                                         @RequestParam String sort,
                                                         @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
        var pageRequest = PageRequest.ofSize(size).withPage(page).withSort(Sort.by(sortDirection, sort));
        return new ResponseEntity<>(bookService.getAll(pageRequest), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Integer id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
     public ResponseEntity<BookResponseDto> update (@RequestBody Integer id, BookUpdateDto bookUpdateDto) {
        return new ResponseEntity<>(bookService.update(id,bookUpdateDto), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookResponseDto>> filter(@RequestBody BookFilterDto bookFilterDto){
        return new ResponseEntity<>(bookService.filter(bookFilterDto), OK);
    }


}
