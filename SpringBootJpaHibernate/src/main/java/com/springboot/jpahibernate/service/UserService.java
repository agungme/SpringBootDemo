package com.springboot.jpahibernate.service;

import com.springboot.jpahibernate.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    User createUser(User user);

    User updateUser(User user, long id);

    ResponseEntity<User> deleteUser(long id);

}
