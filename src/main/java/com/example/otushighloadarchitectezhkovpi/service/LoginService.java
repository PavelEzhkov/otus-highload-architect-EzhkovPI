package com.example.otushighloadarchitectezhkovpi.service;

import com.example.otushighloadarchitectezhkovpi.dto.LoginDto;
import com.example.otushighloadarchitectezhkovpi.dto.TokenDto;
import com.example.otushighloadarchitectezhkovpi.exception.BadRequestException;
import com.example.otushighloadarchitectezhkovpi.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenDto getToken(LoginDto loginDto) {
        var user = userService.get(loginDto.id());
        if (passwordEncoder.matches(loginDto.password(), user.getPassword())) {
            return new TokenDto(jwtTokenProvider.generateToken(user));
        } else {
            throw new BadRequestException();
        }
    }

}
