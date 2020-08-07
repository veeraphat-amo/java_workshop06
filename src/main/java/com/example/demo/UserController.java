package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/api/v1/toys")
    public UserResponse getAllToys(
            @RequestParam() int age,
            @RequestParam() String gender) {

        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Scrabble", "over8", "Neutral", 19.95, true, "Geektoys"));
        UserResponse userResponse = new UserResponse(10,10,age,gender,toys);
        Iterable<User> users = (List<User>) userRepository.findAll();

        return userResponse;
    }




}
