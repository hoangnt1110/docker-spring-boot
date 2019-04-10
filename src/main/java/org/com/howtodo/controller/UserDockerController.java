package org.com.howtodo.controller;

import org.com.howtodo.beans.User;
import org.com.howtodo.dto.CreateUserRequest;
import org.com.howtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserDockerController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> get() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CreateUserRequest request) {
        repository.save(new User(request.getId(), request.getName()));
        return ResponseEntity.ok().build();
    }
}
