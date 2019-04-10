package org.com.howtodo.controller;

import org.com.howtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ResumeDockerController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public String helloDocker() {
        System.out.println("USERSSSSSSSSSSSSSS:" + repository.findAll());
        return "index";
    }
}
