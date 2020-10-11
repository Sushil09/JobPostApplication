package com.sjsushil09.restfulwebservice.controller;

import com.sjsushil09.restfulwebservice.daoservice.PostService;
import com.sjsushil09.restfulwebservice.daoservice.UserService;
import com.sjsushil09.restfulwebservice.model.JobPost;
import com.sjsushil09.restfulwebservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    //to fetch posts as per User
    @GetMapping("/users/{id}/posts")
    public List<JobPost> getPostByUser(@PathVariable int id){
        Optional<User> user=userService.findById(id);
        return user.get().getJobPosts();
    }

    // to enter a jobPost
    @PostMapping("/users/{id}/post")
    public JobPost savePost(@PathVariable int id,@RequestBody JobPost post){
        Optional<User> userOptional=userService.findById(id);
        User user=userOptional.get();
        post.setUser(user);
        postService.save(post);
        return post;
    }

    //to fetch all job posts
    @GetMapping("/posts")
    public List<JobPost> getALlPosts(){
        return postService.findAll();
    }
}
