package com.example.springbootlibrary.service.impl;

import com.example.springbootlibrary.exception.UserNotFoundException;
import com.example.springbootlibrary.mapper.UserMapper;
import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.dto.UserUpdateDto;
import com.example.springbootlibrary.repo.UserRepo;
import com.example.springbootlibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public UserResponseDto getById(Long id) {
        var userEntity = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("UserEntity not found"));
        return userMapper.toUserResponseDto(userEntity);
    }

    @Override
    @Transactional
    public UserResponseDto update(UserUpdateDto userUpdateDto) {
        var user = userMapper.toUser(userUpdateDto);
        return userMapper.toUserResponseDto(userRepo.save(user));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
