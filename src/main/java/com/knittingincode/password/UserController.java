package com.knittingincode.password;

import com.knittingincode.password.repository.User;
import com.knittingincode.password.repository.UserRepository;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alisaarnold on 1/18/18.
 */
@RestController
@RequestMapping("/users")
public class UserController  {
    private UserRepository userRepository;

    @Autowired
    public UserController (UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @GetMapping
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
