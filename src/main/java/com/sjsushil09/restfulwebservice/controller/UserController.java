package com.sjsushil09.restfulwebservice.controller;

import com.sjsushil09.restfulwebservice.daoservice.UserService;
import com.sjsushil09.restfulwebservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //to fetch all users
    @GetMapping("/users")
    public List<User> retrieveAll(){
        return userService.findAll();
    }

    //to fetch particular user
    @GetMapping("/user/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        Optional<User> user=userService.findById(id);
        if(!user.isPresent())
            return null;
        return user;
    }

    // to delete a user
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

}
