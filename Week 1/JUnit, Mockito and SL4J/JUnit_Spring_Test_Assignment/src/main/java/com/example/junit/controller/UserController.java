package com.example.junit.controller;
import com.example.junit.entity.User;
import com.example.junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController{
 @Autowired private UserService service;
 @GetMapping("/{id}") public ResponseEntity<User> getUser(@PathVariable Long id){return ResponseEntity.ok(service.getUserById(id));}
 @PostMapping public ResponseEntity<User> createUser(@RequestBody User user){return ResponseEntity.ok(service.saveUser(user));}
}
