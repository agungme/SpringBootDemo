package com.springboot.user.controller;

import com.springboot.user.client.TicketClient;
import com.springboot.user.entity.Ticket;
import com.springboot.user.entity.User;
import com.springboot.user.exception.ResourceNotFoundException;
import com.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketClient ticketClient;

    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") long id) {
        return this.userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found id: " + id));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable ("id") long id) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ("id") long id){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/tickets")
    public List<Ticket> getTicketsByUserId(@PathVariable (value = "id") long id) {
        return this.ticketClient.getByUserId(id);
    }

}
