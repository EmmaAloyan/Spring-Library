package com.example.springbootlibrary.service.impl;

import com.example.springbootlibrary.mapper.UserMapper;
import com.example.springbootlibrary.model.dto.UserRequestDto;
import com.example.springbootlibrary.model.dto.UserResponseDto;
import com.example.springbootlibrary.model.entity.UserEntity;
import com.example.springbootlibrary.model.entity.RoleEntity;
import com.example.springbootlibrary.repo.UserRepo;
import com.example.springbootlibrary.service.AuthService;
import com.example.springbootlibrary.util.EmailSender;
import com.example.springbootlibrary.util.constants.Role;
import com.example.springbootlibrary.util.jwt.JwtProvider;
import com.example.springbootlibrary.util.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final EmailSender emailSender;



    @Override
    @Transactional
    public UserResponseDto creat(UserRequestDto userRequestDto) {
        var userEntity = userMapper.toUser(userRequestDto);
        userEntity.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        if (userRequestDto.getDateOfBirth() != null) {
            var age = LocalDate.now().getYear() - userRequestDto.getDateOfBirth().getYear();
            userEntity.setAge(age);
        }
        userEntity.setRole(RoleEntity.builder().id(2L).name(Role.USER).build());
        userEntity.setCode(RandomGenerator.generateCode(5));
        userEntity.setVerified(false);
        userEntity.setActive(false);
        UserEntity save = userRepo.save(userEntity);
        //   emailSender.sendSimpleMessage(userEntity.getEmail(), "Vareification Code", userEntity.getCode());
        return userMapper.toUserResponseDto(save);
    }

    @Override
    @Transactional
    public String login(String username, String password) {
        var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        var user = (UserEntity) authenticate.getPrincipal();
        return jwtProvider.generateAccessToken(user.getId(),user.getUsername(),user.getRole().getName());
    }


}
