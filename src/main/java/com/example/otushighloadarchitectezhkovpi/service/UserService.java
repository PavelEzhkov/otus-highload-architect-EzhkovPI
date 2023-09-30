package com.example.otushighloadarchitectezhkovpi.service;

import com.example.otushighloadarchitectezhkovpi.dto.RegisterUserDto;
import com.example.otushighloadarchitectezhkovpi.dto.UserIdDto;
import com.example.otushighloadarchitectezhkovpi.dto.UserInfoDto;
import com.example.otushighloadarchitectezhkovpi.entity.User;
import com.example.otushighloadarchitectezhkovpi.exception.NotFoundException;
import com.example.otushighloadarchitectezhkovpi.mapper.UserMapper;
import com.example.otushighloadarchitectezhkovpi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserIdDto save(RegisterUserDto registerUserDto) {
        return new UserIdDto(repository.save(mapper.toUser(registerUserDto)).getId());
    }

    public User get(UUID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public UserInfoDto getInfo(UUID id) {
        return mapper.toUserInfoDro(get(id));
    }

}
