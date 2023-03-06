package com.javaWithReact.users.service;

import com.javaWithReact.users.entity.Users;
import com.javaWithReact.users.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public Users saveUser(Users users){
        users.setId(new Random().nextInt());
       return userRepository.save(users);

    }

    public void deleteUser(Long id){
        userRepository.deleteAllById(Collections.singleton(id));
    }
}
