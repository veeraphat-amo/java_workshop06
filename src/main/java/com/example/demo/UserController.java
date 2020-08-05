package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public PagingResponse getAllUser(
            @RequestParam(defaultValue ="1") int page,
            @RequestParam(name = "item_per_page", defaultValue = "30") int itemPerPage) {

        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);
        List<UserResponse> usersResponseList = new ArrayList<>();
        pagingResponse.setUsersResponse(usersResponseList);

        usersResponseList.add(new UserResponse(1, "User 1"));
        usersResponseList.add(new UserResponse(2, "User 2"));
        usersResponseList.add(new UserResponse(3, "User 3"));

        return pagingResponse;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }

    @PostMapping("/users")
    public UserResponse createNewUser(@RequestBody NewUserRequest request) {
        // Validate input
        // Create new user into database =>
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), request.getName() + request.getAge());
    }

    /*@PostMapping(
            path = "/users1"
    )
    public String createNewUserWithFormData(NewUserRequest request) {
        return request.getName() + request.getAge();
    } */



}
