package com.recipe.recipe_sharing.service;

import com.recipe.recipe_sharing.model.User;
import com.recipe.recipe_sharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation  implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt = userRepository.findById(userId);
        if(opt.isPresent()){
            return opt.get();
        }
        else {
            throw  new Exception("User Not Found with id: "+userId);
        }
    }
}
