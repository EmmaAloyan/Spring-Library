package com.example.springbootlibrary.mapper;

import com.example.springbootlibrary.model.dto.UserRequestDto;
import com.example.springbootlibrary.model.dto.UserUpdateDto;
import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUser(UserRequestDto userRequestDto);
    UserEntity toUser(UserUpdateDto userUpdateDto);

    UserResponseDto toUserResponseDto(UserEntity userEntity);

}
