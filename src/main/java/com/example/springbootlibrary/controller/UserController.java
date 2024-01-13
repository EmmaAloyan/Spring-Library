package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.dto.UserUpdateDto;
import com.example.springbootlibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    ResponseEntity<UserResponseDto> getById (@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<UserResponseDto> update (@RequestBody UserUpdateDto userUpdateDto){
        return new ResponseEntity<>(userService.update(userUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Void> delete ( @PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
         }

}
