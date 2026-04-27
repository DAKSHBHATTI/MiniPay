package com.minipay.service;

import com.minipay.dto.UserRequest;
import com.minipay.exception.UserNotFoundException;
import com.minipay.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class UserService {
    private long userIdCounter=1000;
    private Map<Long, User> users=new HashMap<>();
    public User registerUser(UserRequest request){
        long id=++userIdCounter;
        User user=new User(id,request.getName(),request.getEmail());
        users.put(id,user);
        return user;
    }
public User getUserById(long userId){
        return Optional.ofNullable(users.get(userId)).orElseThrow(()->new UserNotFoundException("User not found: " + userId));
}
}
