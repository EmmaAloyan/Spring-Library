package com.example.springbootlibrary.service;


import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.dto.UserUpdateDto;

public interface UserService {
    UserResponseDto getById (Long id);
    UserResponseDto update (UserUpdateDto userUpdateDto);
    void delete (Long id);

}
