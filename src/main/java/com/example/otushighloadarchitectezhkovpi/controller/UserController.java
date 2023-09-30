package com.example.otushighloadarchitectezhkovpi.controller;

import com.example.otushighloadarchitectezhkovpi.dto.RegisterUserDto;
import com.example.otushighloadarchitectezhkovpi.dto.UserIdDto;
import com.example.otushighloadarchitectezhkovpi.dto.UserInfoDto;
import com.example.otushighloadarchitectezhkovpi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserIdDto register(@RequestBody RegisterUserDto registerUserDto) {
        return userService.save(registerUserDto);
    }

    @GetMapping("/get/{id}")
    public UserInfoDto get(@PathVariable UUID id) {
        return userService.getInfo(id);
    }
}
