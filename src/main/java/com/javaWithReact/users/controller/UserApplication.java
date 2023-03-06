package com.javaWithReact.users.controller;

import com.javaWithReact.users.entity.Users;
import com.javaWithReact.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://createuser.com:3000","http://createuser.hi:3000"})
@RestController
@RequestMapping("/api/")
public class UserApplication {
    @Autowired
    UserService userService;

    @GetMapping(path= "listUser")
    public ResponseEntity<List<Users>> listUsers(){
       List<Users> allUsers= userService.getUsers();
       return ResponseEntity.ok(allUsers);
    }

    @PostMapping(path="addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users users){
     Users newUser= userService.saveUser(users);
     return ResponseEntity.ok(newUser);
    }

    @GetMapping(path="totalUser")
    public ResponseEntity<Integer> getTotalCountOfUser(){
        List<Users> allUsers= userService.getUsers();
        return ResponseEntity.ok(allUsers.size());
    }
    @DeleteMapping(path="delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }

}
