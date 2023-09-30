package com.example.otushighloadarchitectezhkovpi.dto;

import java.util.Date;

public record RegisterUserDto(String firstName, String secondName, Date birthdate, String biography, String city,
                              String password) {
}

