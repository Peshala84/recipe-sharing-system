package com.recipe.recipe_sharing.service;

import com.recipe.recipe_sharing.model.User;

public interface UserService {

       public User findUserById(Long userId) throws Exception;

}
