package com.example.springbootlibrary.service;

import com.example.springbootlibrary.model.dto.UserRequestDto;
import com.example.springbootlibrary.model.dto.UserResponseDto;


public interface AuthService {
    UserResponseDto creat (UserRequestDto userRequestDto);

    String login (String username, String password);
}
