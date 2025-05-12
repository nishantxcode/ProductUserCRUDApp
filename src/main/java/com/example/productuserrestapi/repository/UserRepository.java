package com.example.productuserrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productuserrestapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
