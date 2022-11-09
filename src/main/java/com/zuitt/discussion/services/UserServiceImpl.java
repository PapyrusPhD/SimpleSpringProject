package com.zuitt.discussion.services;

import com.zuitt.discussion.models.User;
import com.zuitt.discussion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    Create user
    public void createUser(User user){
        userRepository.save(user);
    }

//    getting all users
    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

//    delete a user

    public ResponseEntity deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

//    update a user
    public ResponseEntity updateUser(Long id, User user) {
        User userForUpdating = userRepository.findById(id).get();

        userForUpdating.setUsername(user.getUsername());
        userForUpdating.setPassword(user.getPassword());
        userRepository.save(userForUpdating);

        return new ResponseEntity<>("User udpated successfully", HttpStatus.OK);
    }

//    Find user by username
    public Optional<User> findByUsername(String username) {
//        if the findByUsername method returns null, it will throw a NullPointerException, to avoid this from happening, let's use .ofNullable method.
        return Optional.ofNullable(userRepository.findByUsername(username));
//validation if the username is empty - can't save the data inside the database
//        if username is already exist - can't save and return username is already exist
    }

}
