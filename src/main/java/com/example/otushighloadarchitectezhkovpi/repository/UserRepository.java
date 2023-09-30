package com.example.otushighloadarchitectezhkovpi.repository;

import com.example.otushighloadarchitectezhkovpi.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
