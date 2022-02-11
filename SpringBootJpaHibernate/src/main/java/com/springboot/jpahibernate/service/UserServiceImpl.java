package com.springboot.jpahibernate.service;

import com.springboot.jpahibernate.entity.User;
import com.springboot.jpahibernate.exception.ResourceNotFoundException;
import com.springboot.jpahibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found id: " + id));
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user, long id) {
        User currUser = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found id: " + id));
        currUser.setUsername(user.getUsername());
        currUser.setPassword(user.getPassword());
        currUser.setFirstname(user.getFirstname());
        currUser.setLastname(user.getLastname());
        currUser.setEmail(user.getEmail());
        currUser.setAge(user.getAge());
        currUser.setStatus(user.isStatus());
        return this.userRepository.save(currUser);
    }

    @Override
    public ResponseEntity<User> deleteUser(long id){
        User existingUser = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found id: " + id));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }

}
