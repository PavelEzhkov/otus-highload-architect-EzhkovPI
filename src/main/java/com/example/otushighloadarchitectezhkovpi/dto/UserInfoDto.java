package com.example.otushighloadarchitectezhkovpi.dto;

import java.util.Date;
import java.util.UUID;

public record UserInfoDto(UUID id, String firstName, String secondName, Date birthdate, String biography, String city) {

}
