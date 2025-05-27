package com.recipe.recipe_sharing.service;

import com.recipe.recipe_sharing.config.JwtProvider;
import com.recipe.recipe_sharing.model.User;
import com.recipe.recipe_sharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation  implements  UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

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

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        if(email == null){
            throw  new Exception("Provide Valid JWT Token");
        }
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("user not found with email "+email);
        }
        return user;
    }
}
