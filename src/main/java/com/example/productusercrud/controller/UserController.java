package com.example.productusercrud.controller;

import com.example.productusercrud.model.User;
import com.example.productusercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAll() { return service.getAll(); }

    @PostMapping
    public User create(@RequestBody User user) { return service.save(user); }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return service.get(id).map(existing -> {
            existing.setName(user.getName());
            existing.setProducts(user.getProducts());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
