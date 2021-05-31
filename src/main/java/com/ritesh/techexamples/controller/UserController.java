package com.ritesh.techexamples.controller;

import com.ritesh.techexamples.dto.ResponseTemplateDTO;
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
        log.info("Inside findall of UserController");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public  User findUserById(@PathVariable("id") Long id) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.findUserById(id);
    }

    @GetMapping("/v2/{id}")
    public ResponseTemplateDTO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping("/message")
    public static void sayHello() {
        System.out.println("Hello!");
    }
}
