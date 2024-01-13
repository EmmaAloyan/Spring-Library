package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.dto.LoginDto;
import com.example.springbootlibrary.model.dto.UserRequestDto;
import com.example.springbootlibrary.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto userRequestDTO) {
        return new ResponseEntity<>(authService.creat(userRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody @Valid LoginDto loginDTO) {
        return new ResponseEntity<>(authService.login(loginDTO.getUsername(), loginDTO.getPassword()), HttpStatus.OK);
    }

}
