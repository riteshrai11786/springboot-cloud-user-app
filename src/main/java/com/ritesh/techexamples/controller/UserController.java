package com.ritesh.techexamples.controller;

import com.ritesh.techexamples.entity.User;
import com.ritesh.techexamples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        log.info("Inside finall of UserController");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public  User findUserById(@PathVariable("id") Long id) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.findUserById(id);
    }

    @GetMapping("/message")
    public static void sayHello() {
        System.out.println("Hello!");
    }
}
