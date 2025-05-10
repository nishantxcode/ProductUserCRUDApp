package com.example.productusercrud.service;

import com.example.productusercrud.model.User;
import com.example.productusercrud.model.Product;
import com.example.productusercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public User save(User user) {
        if (user.getProducts() != null) {
            for (Product product : user.getProducts()) {
                product.setUser(user); // Link each product to this user
            }
        }
        return repo.save(user);
    }

    public Optional<User> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
