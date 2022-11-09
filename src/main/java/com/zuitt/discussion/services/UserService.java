package com.zuitt.discussion.services;

import com.zuitt.discussion.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

//    create a user
void createUser(User user);

//getting all users
    Iterable<User> getUsers();

//    delete a user
    ResponseEntity deleteUser(Long id);

//    update a user
    ResponseEntity updateUser(Long id, User user);

//    Add an abstract method named "findByUserName()" that returns an optional instance of the User class upon receiving a string
    Optional<User> findByUsername(String username);

}
