package com.example.productuserrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productuserrestapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
