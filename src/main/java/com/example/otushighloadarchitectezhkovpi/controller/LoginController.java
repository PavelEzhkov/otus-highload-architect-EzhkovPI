package com.example.otushighloadarchitectezhkovpi.controller;

import com.example.otushighloadarchitectezhkovpi.dto.LoginDto;
import com.example.otushighloadarchitectezhkovpi.dto.TokenDto;
import com.example.otushighloadarchitectezhkovpi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return loginService.getToken(loginDto);
    }
}
