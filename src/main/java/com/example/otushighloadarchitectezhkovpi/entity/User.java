package com.example.otushighloadarchitectezhkovpi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Persistable {
    @Id
    private UUID id;
    private String firstName;
    private String secondName;
    private Date birthdate;
    private String biography;
    private String city;
    private String password;

    @Override
    public boolean isNew() {
        return true;
    }
}
