package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserResponse> getAllUser(
            @RequestParam(required = false, defaultValue ="1") int page,
            @RequestParam(required = false, defaultValue = "30") int item) {

        List<UserResponse> usersResponseList = new ArrayList<>();
        for(int i=1;i<=item;i++){
            usersResponseList.add(new UserResponse(i, "User "+i+", page: "+page));
        }
        return usersResponseList;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }

}
