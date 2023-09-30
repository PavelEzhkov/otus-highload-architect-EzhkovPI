package com.example.otushighloadarchitectezhkovpi.mapper;

import com.example.otushighloadarchitectezhkovpi.dto.RegisterUserDto;
import com.example.otushighloadarchitectezhkovpi.dto.UserInfoDto;
import com.example.otushighloadarchitectezhkovpi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserInfoDto toUserInfoDro(User user) {
        return new UserInfoDto(user.getId(), user.getFirstName(), user.getSecondName(), user.getBirthdate(),
                user.getBiography(), user.getCity());
    }

    public User toUser(RegisterUserDto registerUserDto) {
        return User.builder()
                .id(UUID.randomUUID())
                .firstName(registerUserDto.firstName())
                .secondName(registerUserDto.secondName())
                .birthdate(registerUserDto.birthdate())
                .biography(registerUserDto.biography())
                .city(registerUserDto.city())
                .password(passwordEncoder.encode(registerUserDto.password()))
                .build();
    }
}
