package com.springboot.jpahibernate.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.springboot.jpahibernate.dto.UserDTO;
import com.springboot.jpahibernate.entity.MyUser;
import com.springboot.jpahibernate.entity.User;
import com.springboot.jpahibernate.mapper.UserMapper;
import com.springboot.jpahibernate.repository.MyUserPredicatesBuilder;
import com.springboot.jpahibernate.repository.MyUserRepository;
import com.springboot.jpahibernate.repository.UserRepository;
import com.springboot.jpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MyUserRepository myUserRepository;

    @Autowired
    private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@GetMapping
	public List<UserDTO> getAllUsers() {
        //return this.userService.getAllUsers();
		return userMapper.toUserDTOs(userService.getAllUsers());
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long id) {
        return this.userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
        //return this.userRepository.save(user);
        return this.userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long id) {
		 return this.userService.updateUser(user,id);
		 //return this.userRepository.save(currUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long id){
		 return userService.deleteUser(id);
		 //return ResponseEntity.ok().build();
	}

	@GetMapping("/querydsl")
	public Iterable<MyUser> getAllUsersQueryDSL(@RequestParam(value = "search") String search) {
		MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder();
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
			}
		}
		BooleanExpression exp = builder.build();
		return myUserRepository.findAll(exp);
	}
}
