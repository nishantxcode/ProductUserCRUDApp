package com.example.productusercrud.service;

import com.example.productusercrud.model.Product;
import com.example.productusercrud.model.User;
import com.example.productusercrud.repository.ProductRepository;
import com.example.productusercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private UserRepository userRepository;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product save(Product product) {
        // Ensure user is properly attached from DB using ID
        if (product.getUser() != null && product.getUser().getId() != null) {
            Optional<User> user = userRepository.findById(product.getUser().getId());
            user.ifPresent(product::setUser);
        }
        return repo.save(product);
    }

    public Optional<Product> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
