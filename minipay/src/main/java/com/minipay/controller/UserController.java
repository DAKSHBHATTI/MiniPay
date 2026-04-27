package com.minipay.controller;

import com.minipay.dto.UserRequest;
import com.minipay.model.User;
import com.minipay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<User>getUserById(@PathVariable long id){
        User user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public ResponseEntity<User>registerUser(@RequestBody UserRequest request){
        User user=userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
