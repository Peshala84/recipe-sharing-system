package com.recipe.recipe_sharing.controller;


import com.recipe.recipe_sharing.model.User;
import com.recipe.recipe_sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
     private UserService userService;

    @GetMapping("/api/users/profile")
    public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {

        User user= userService.findUserByJwt(jwt);

        return user;

    }
}
